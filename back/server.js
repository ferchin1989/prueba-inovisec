/**
 * server.js - Punto de entrada principal para el servidor de la API de Inovisec
 * 
 * Este archivo configura y arranca el servidor Express que maneja las solicitudes
 * de la aplicación móvil, incluyendo la autenticación y datos del mapa.
 */

// Importación de módulos de terceros
const express = require('express');    // Framework web para Node.js
const cors = require('cors');         // Middleware para habilitar CORS
const bodyParser = require('body-parser'); // Middleware para parsear el cuerpo de las solicitudes

// Importación de módulos propios
const authRoutes = require('./routes/auth'); // Rutas de autenticación

// Inicialización de la aplicación Express
const app = express();
const PORT = process.env.PORT || 3000; // Puerto del servidor (usa variable de entorno o 3000 por defecto)

// Configuración de middleware
app.use(cors()); // Habilita Cross-Origin Resource Sharing para todas las rutas
app.use(bodyParser.json()); // Parsea solicitudes con Content-Type: application/json
app.use(bodyParser.urlencoded({ extended: true })); // Parsea solicitudes con Content-Type: application/x-www-form-urlencoded

// Registro de solicitudes (logger básico)
app.use((req, res, next) => {
  console.log(`${new Date().toISOString()} - ${req.method} ${req.url}`);
  next();
});

// Configuración de rutas de la API
app.use('/api/auth', authRoutes); // Rutas de autenticación bajo /api/auth

/**
 * Ruta raíz - Punto de entrada principal a la API
 * 
 * @route   GET /
 * @desc    Devuelve un mensaje de bienvenida para verificar que el servidor está funcionando
 * @access  Public
 */
app.get('/', (req, res) => {
  res.json({ 
    message: 'Bienvenido a la API de Inovisec',
    version: '1.0.0',
    status: 'online'
  });
});

/**
 * Middleware de manejo de errores global
 * Captura cualquier error no manejado en las rutas y devuelve una respuesta JSON apropiada
 */
app.use((err, req, res, next) => {
  // Registrar el error en la consola para depuración
  console.error(`Error: ${err.message}`);
  console.error(err.stack);
  
  // Enviar respuesta de error al cliente
  res.status(500).json({
    success: false,
    message: 'Error interno del servidor',
    // Solo incluir detalles del error en entorno de desarrollo
    error: process.env.NODE_ENV === 'development' ? err.message : {}
  });
});

// Manejo de rutas no encontradas (404)
app.use((req, res) => {
  res.status(404).json({
    success: false,
    message: 'Ruta no encontrada'
  });
});

// Iniciar el servidor HTTP
const server = app.listen(PORT, () => {
  console.log(`Servidor Inovisec iniciado en el puerto ${PORT}`);
  console.log(`Tiempo de inicio: ${new Date().toLocaleString()}`);
});

// Manejo de señales de terminación para cierre graceful
process.on('SIGTERM', () => {
  console.log('Recibida señal SIGTERM. Cerrando servidor...');
  server.close(() => {
    console.log('Servidor cerrado.');
    process.exit(0);
  });
});

// Exportar la aplicación para pruebas unitarias o importación desde otros módulos
module.exports = app;
