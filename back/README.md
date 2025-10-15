# Backend para la Prueba de Desarrollo Móvil de Inovisec

Este servidor proporciona una API REST para la autenticación de usuarios y datos para la inicialización del mapa en la aplicación móvil.

## Tecnologías utilizadas

- Node.js
- Express.js
- CORS para manejo de solicitudes cross-origin
- Body-parser para procesar solicitudes JSON

## Estructura del proyecto

```
back/
  ├── node_modules/       # Dependencias (generadas al instalar)
  ├── routes/             # Rutas de la API
  │   └── auth.js         # Rutas de autenticación
  ├── package.json        # Configuración del proyecto y dependencias
  ├── package-lock.json   # Versiones exactas de dependencias (generado al instalar)
  ├── server.js           # Punto de entrada del servidor
  └── README.md           # Este archivo
```

## Instalación

1. Asegúrate de tener Node.js instalado (versión 14.x o superior recomendada)
2. Navega al directorio del proyecto
3. Instala las dependencias:

```bash
npm install
```

## Ejecución

Para iniciar el servidor en modo desarrollo (con recarga automática):

```bash
npm run dev
```

Para iniciar el servidor en modo producción:

```bash
npm start
```

El servidor se ejecutará en el puerto 3000 por defecto. Puedes cambiar esto configurando la variable de entorno PORT.

## API Endpoints

### Autenticación

**POST /api/auth/login**

Autentica a un usuario y devuelve datos para inicializar la aplicación.

Cuerpo de la solicitud:
```json
{
  "email": "usuario@ejemplo.com",
  "password": "123456"
}
```

Respuesta exitosa (200 OK):
```json
{
  "success": true,
  "message": "Inicio de sesión exitoso",
  "user": {
    "id": "1",
    "email": "usuario@ejemplo.com",
    "name": "Usuario de Prueba"
  },
  "mapData": {
    "initialLocation": {
      "latitude": 19.432608,
      "longitude": -99.133209,
      "zoom": 15
    },
    "markers": [
      {
        "id": 1,
        "latitude": 19.432608,
        "longitude": -99.133209,
        "title": "Marcador de ejemplo"
      }
    ]
  }
}
```

Respuesta de error (401 Unauthorized):
```json
{
  "success": false,
  "message": "Credenciales inválidas"
}
```

## Credenciales de prueba

Para probar la API, puedes usar las siguientes credenciales:

- Email: usuario@ejemplo.com
- Password: 123456
