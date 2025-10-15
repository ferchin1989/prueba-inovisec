# Prueba de Desarrollo Móvil: Inovisec

Este proyecto implementa una aplicación móvil con un formulario de inicio de sesión y una pantalla de mapa con Google Maps, junto con un servidor backend para la autenticación. Desarrollado como parte de la prueba técnica para Inovisec.

## Estructura del proyecto

El proyecto está dividido en dos partes principales:

- **android/**: Aplicación Android desarrollada con Kotlin y Jetpack Compose
- **back/**: Servidor backend desarrollado con Node.js y Express.js

## Tecnologías utilizadas

### Frontend (Android)
- **Kotlin**: Lenguaje principal de desarrollo
- **Jetpack Compose**: Framework moderno para construir interfaces de usuario nativas
- **Google Maps API**: Para la implementación del mapa interactivo
- **Retrofit**: Cliente HTTP para realizar llamadas a la API
- **ViewModel**: Para manejar la lógica de presentación y estados de la UI
- **StateFlow**: Para manejar estados reactivos en la aplicación
- **Coroutines**: Para operaciones asíncronas

### Backend
- **Node.js**: Entorno de ejecución para JavaScript del lado del servidor
- **Express.js**: Framework web minimalista y flexible para Node.js
- **CORS**: Middleware para habilitar solicitudes cross-origin
- **Body-parser**: Middleware para analizar cuerpos de solicitudes HTTP

## Requisitos previos

- Android Studio Hedgehog (2023.1.1) o superior
- Node.js v16.x o superior
- npm v8.x o superior
- Clave API de Google Maps (con APIs de Maps, Places y Directions habilitadas)
- Dispositivo Android con API level 24 (Android 7.0) o superior, o un emulador configurado

## Instalación y ejecución

### Backend

1. Navega al directorio del backend:
```bash
cd back
```

2. Instala las dependencias:
```bash
npm install
```

3. Inicia el servidor:
```bash
npm run dev
```

El servidor se ejecutará en `http://localhost:3000`.

### Frontend (Android)

1. Abre el proyecto en Android Studio desde el directorio `android/`
2. Configura tu clave API de Google Maps en el archivo `local.properties`:
```properties
MAPS_API_KEY=tu_clave_api_aqui
```
3. Ejecuta la aplicación en un emulador o dispositivo físico

## Credenciales de prueba

Para probar la aplicación, puedes usar las siguientes credenciales:

- Email: usuario@ejemplo.com
- Password: 123456

## Funcionalidades implementadas

- **Formulario de inicio de sesión con validación**: Validación de formato de correo electrónico y contraseña
- **Autenticación mediante API REST**: Comunicación segura con el servidor backend
- **Pantalla de mapa con Google Maps**: Visualización de mapa con estilo oscuro personalizado
- **Selector de tipo de vehículo**: Interfaz para seleccionar diferentes tipos de vehículos
- **Manejo de errores y estados de carga**: Feedback visual mediante diálogos y toasts
- **Diseño responsive**: Adaptable a diferentes tamaños de pantalla y orientaciones
- **Permisos de ubicación**: Solicitud y manejo de permisos para acceder a la ubicación del usuario

## Decisiones de diseño

- **Arquitectura MVVM**: Se implementó el patrón Model-View-ViewModel para una mejor separación de responsabilidades y facilitar las pruebas unitarias
- **Jetpack Compose**: Se eligió este framework por ser la tecnología más moderna y recomendada por Google para el desarrollo de interfaces de usuario en Android
- **Tema oscuro**: Se diseñó la aplicación con un tema oscuro para mejorar la legibilidad y reducir la fatiga visual, especialmente útil para aplicaciones de navegación
- **Estilo minimalista**: Se optó por un diseño limpio y minimalista para mejorar la usabilidad y la experiencia del usuario
- **Retrofit para API**: Se utilizó Retrofit por su facilidad de uso, flexibilidad y soporte para corrutinas
- **Express.js para backend**: Se eligió Express.js por su simplicidad, eficiencia y amplia adopción en la comunidad

## Mejoras futuras

- Implementación de autenticación con JWT para mayor seguridad
- Almacenamiento de credenciales usando EncryptedSharedPreferences
- Implementación de rutas reales usando la API Directions de Google
- Añadir soporte para modo claro/oscuro basado en la configuración del sistema
- Implementar tests unitarios y de UI

## Autor

Raul Fernando Castaño Arias 
## Licencia

Todos los derechos reservados © 2025
