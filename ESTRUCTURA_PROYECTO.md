# Estructura del Proyecto Inovisec

Este documento detalla la estructura y organización del proyecto Inovisec, explicando los directorios principales y su propósito.

## Visión general

El proyecto está dividido en dos componentes principales:

1. **Aplicación Android (frontend)**: Desarrollada con Kotlin y Jetpack Compose
2. **Servidor backend**: Desarrollado con Node.js y Express.js

## Estructura de directorios

```
prueba-inovisec/
├── android/                  # Aplicación Android
│   ├── app/                  # Módulo principal de la aplicación
│   │   ├── src/              # Código fuente
│   │   │   ├── main/         # Código principal
│   │   │   │   ├── java/     # Código Kotlin
│   │   │   │   │   └── com/modrob/inovisec/
│   │   │   │   │       ├── data/           # Capa de datos
│   │   │   │   │       │   ├── api/        # Servicios API
│   │   │   │   │       │   ├── model/      # Modelos de datos
│   │   │   │   │       │   └── repository/ # Repositorios
│   │   │   │   │       ├── ui/             # Capa de UI
│   │   │   │   │       │   ├── login/      # Pantalla de login
│   │   │   │   │       │   ├── map/        # Pantalla de mapa
│   │   │   │   │       │   └── theme/      # Temas y estilos
│   │   │   │   │       └── MainActivity.kt # Actividad principal
│   │   │   │   ├── res/      # Recursos (layouts, strings, etc.)
│   │   │   │   └── AndroidManifest.xml
│   │   │   └── test/         # Pruebas unitarias e instrumentadas
│   │   └── build.gradle.kts  # Configuración de Gradle para el módulo app
│   ├── build.gradle.kts      # Configuración de Gradle para el proyecto
│   └── gradle/               # Configuración de Gradle Wrapper
├── back/                     # Servidor backend
│   ├── node_modules/         # Dependencias de Node.js (generado)
│   ├── routes/               # Rutas de la API
│   │   └── auth.js           # Rutas de autenticación
│   ├── package.json          # Dependencias y scripts
│   └── server.js             # Punto de entrada del servidor
└── docs/                     # Documentación adicional
```

## Componentes principales

### Frontend (Android)

#### Arquitectura MVVM

La aplicación Android sigue el patrón de arquitectura Model-View-ViewModel (MVVM):

- **Model**: Representa los datos y la lógica de negocio
  - `data/model/`: Clases de datos (DTOs)
  - `data/repository/`: Implementaciones de repositorios que obtienen datos

- **View**: Representa la interfaz de usuario
  - `ui/login/LoginScreen.kt`: Pantalla de inicio de sesión
  - `ui/map/MapScreen.kt`: Pantalla del mapa

- **ViewModel**: Actúa como intermediario entre el Model y la View
  - `ui/login/LoginViewModel.kt`: ViewModel para la pantalla de login
  - `ui/map/MapViewModel.kt`: ViewModel para la pantalla del mapa

#### Componentes clave

1. **MainActivity.kt**: Actividad principal que gestiona la navegación entre pantallas
2. **AuthApi.kt**: Interfaz para comunicarse con el backend
3. **AuthRepository.kt**: Repositorio que maneja la lógica de autenticación
4. **LoginScreen.kt**: Pantalla de inicio de sesión con validación de formulario
5. **MapScreen.kt**: Pantalla que muestra el mapa de Google Maps

### Backend (Node.js)

#### Estructura MVC simplificada

El backend sigue una estructura MVC simplificada:

- **Model**: Representado implícitamente (sin base de datos en esta versión)
- **View**: Representado por las respuestas JSON
- **Controller**: Lógica de manejo de solicitudes en las rutas

#### Componentes clave

1. **server.js**: Punto de entrada principal que configura el servidor Express
2. **routes/auth.js**: Define las rutas de autenticación y su lógica

## Flujo de datos

1. El usuario introduce credenciales en la pantalla de login
2. LoginViewModel valida los datos y llama al AuthRepository
3. AuthRepository hace una solicitud HTTP al backend a través de AuthApi
4. El backend valida las credenciales y devuelve una respuesta
5. En caso de éxito, la aplicación navega a la pantalla del mapa
6. MapScreen muestra el mapa de Google Maps con los datos recibidos

## Patrones de diseño utilizados

1. **Singleton**: Para instancias únicas como el repositorio
2. **Repository**: Para abstraer la fuente de datos
3. **Dependency Injection**: Para proporcionar dependencias a las clases
4. **Observer**: Para reaccionar a cambios de estado (StateFlow)

## Convenciones de nomenclatura

- **Clases Kotlin**: PascalCase (ej. LoginViewModel)
- **Funciones Kotlin**: camelCase (ej. validateEmail)
- **Archivos JavaScript**: camelCase (ej. authRoutes.js)
- **Variables JavaScript**: camelCase (ej. userCredentials)
- **Constantes**: UPPER_SNAKE_CASE (ej. MAX_LOGIN_ATTEMPTS)

---

Documento elaborado por: Raul Fernando Castaño Arias  
Fecha: Octubre 2025
