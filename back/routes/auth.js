/**
 * auth.js - Rutas de autenticación para la API de Inovisec
 * 
 * Este archivo contiene las rutas relacionadas con la autenticación de usuarios,
 * incluyendo inicio de sesión y validación de credenciales.
 */

// Importación de módulos necesarios
const express = require('express'); // Framework web para Node.js
const router = express.Router(); // Router de Express para definir rutas

/**
 * Ruta para autenticar usuarios
 * 
 * @route   POST api/auth/login
 * @desc    Autentica al usuario con email y contraseña, devuelve datos del usuario y del mapa
 * @access  Public - No requiere autenticación previa
 * @param   {Object} req.body - Contiene email y password del usuario
 * @returns {Object} Respuesta JSON con estado de éxito/error y datos relevantes
 */
router.post('/login', (req, res) => {
  try {
    // Extraer credenciales del cuerpo de la solicitud
    const { email, password } = req.body;
    
    // Validación de campos requeridos
    if (!email || !password) {
      return res.status(400).json({
        success: false,
        message: 'Por favor, proporcione correo electrónico y contraseña'
      });
    }   
    
    // Para esta prueba técnica, usamos credenciales hardcodeadas
    
    // Verificación de credenciales
    if (email === 'usuario@ejemplo.com' && password === '123456') {
      // Autenticación exitosa - devolver datos del usuario y del mapa
      return res.status(200).json({
        success: true,
        message: 'Inicio de sesión exitoso',
        // Datos del usuario autenticado
        user: {
          id: '1',
          email: email,
          name: 'Usuario de Prueba'
        },
        // Datos para inicializar el mapa (coordenadas de la Ciudad de México)
        mapData: {
          initialLocation: {
            latitude: 19.432608,  // Latitud del centro de CDMX
            longitude: -99.133209, // Longitud del centro de CDMX
            zoom: 15              // Nivel de zoom inicial
          },
          // Marcadores que se mostrarán en el mapa
          markers: [
            {
              id: 1,
              latitude: 19.432608,
              longitude: -99.133209,
              title: 'Marcador de ejemplo'
            }
          ]
        }
      });
    } else {
      // Autenticación fallida - credenciales incorrectas
      return res.status(401).json({
        success: false,
        message: 'Credenciales inválidas'
      });
    }
  } catch (error) {
    // Manejo de errores inesperados
    console.error('Error en la autenticación:', error);
    
    // Respuesta genérica de error (no expone detalles internos en producción)
    return res.status(500).json({
      success: false,
      message: 'Error en el servidor',
      // Solo incluir detalles del error en entorno de desarrollo
      error: process.env.NODE_ENV === 'development' ? error.message : 'Error interno'
    });
  }
});

// Exportar el router para usarlo en server.js
module.exports = router;
