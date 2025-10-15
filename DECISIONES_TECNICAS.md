# Decisiones Técnicas - Proyecto Inovisec

Este documento explica en detalle las decisiones técnicas y de diseño tomadas durante el desarrollo de la aplicación Inovisec.

## Arquitectura general

El proyecto sigue una arquitectura cliente-servidor:

- **Cliente**: Aplicación Android desarrollada con Kotlin y Jetpack Compose
- **Servidor**: API REST desarrollada con Node.js y Express.js

## Frontend (Android)

### Arquitectura MVVM

Se implementó el patrón Model-View-ViewModel (MVVM) por las siguientes razones:

1. **Separación de responsabilidades**: Clara separación entre la UI (View), la lógica de presentación (ViewModel) y los datos (Model)
2. **Testabilidad**: Facilita la escritura de pruebas unitarias al aislar la lógica de negocio
3. **Mantenibilidad**: Código más organizado y fácil de mantener
4. **Integración con Jetpack**: MVVM es el patrón recomendado por Google para aplicaciones Android modernas

### Componentes principales:

- **View**: Implementada con Jetpack Compose (LoginScreen, MapScreen)
- **ViewModel**: Contiene la lógica de presentación y estados de UI (LoginViewModel)
- **Repository**: Capa intermedia que gestiona las fuentes de datos (AuthRepository)
- **API Service**: Interfaz para comunicarse con el backend (AuthApi)
- **Model**: Clases de datos para representar la información (LoginRequest, LoginResponse)

### Jetpack Compose

Se eligió Jetpack Compose como framework de UI por:

1. **Modernidad**: Es la tecnología más reciente y recomendada por Google para el desarrollo de interfaces en Android
2. **Declarativo**: Permite describir la UI de forma declarativa, lo que reduce el código boilerplate
3. **Reactividad**: Actualiza automáticamente la UI cuando cambian los datos
4. **Componentes reutilizables**: Facilita la creación de componentes UI reutilizables
5. **Interoperabilidad**: Se integra bien con las bibliotecas existentes de Android

### Gestión de estados

Para la gestión de estados se utilizaron:

1. **StateFlow**: Para exponer estados observables desde el ViewModel a la UI
2. **Coroutines**: Para operaciones asíncronas como llamadas a la API
3. **Estados sellados (sealed class)**: Para representar los diferentes estados de la UI (idle, loading, success, error)

### Google Maps

Para la implementación del mapa se utilizó:

1. **Maps Compose**: Biblioteca oficial para integrar Google Maps con Jetpack Compose
2. **Estilo personalizado**: Se aplicó un estilo oscuro al mapa para mantener la coherencia con el diseño general
3. **Permisos de ubicación**: Implementación de solicitud y manejo de permisos de ubicación

### Networking

Para las llamadas a la API se utilizó:

1. **Retrofit**: Cliente HTTP tipo-seguro para Android
2. **Gson**: Para la serialización/deserialización de JSON
3. **OkHttp**: Como cliente HTTP subyacente, con interceptor de logging para depuración

## Backend (Node.js)

### Express.js

Se eligió Express.js como framework web por:

1. **Simplicidad**: API minimalista y fácil de aprender
2. **Flexibilidad**: No impone una estructura rígida
3. **Rendimiento**: Eficiente y con bajo overhead
4. **Ecosistema**: Gran cantidad de middleware disponible

### Estructura del servidor

1. **Rutas**: Definición de endpoints de la API
2. **Controladores**: Lógica de negocio para cada endpoint
3. **Middleware**: Funciones intermedias para procesar solicitudes (CORS, body-parser)
4. **Manejo de errores**: Middleware global para capturar y responder a errores

### Autenticación

Para esta prueba de concepto, se implementó una autenticación simple basada en credenciales hardcodeadas. En un entorno de producción, se recomendaría:

1. **JWT (JSON Web Tokens)**: Para autenticación sin estado
2. **Almacenamiento seguro**: Base de datos para usuarios y contraseñas hasheadas
3. **HTTPS**: Para cifrar la comunicación entre cliente y servidor

## Decisiones de diseño visual

### Tema oscuro

Se optó por un tema oscuro por:

1. **Usabilidad en navegación**: Reduce la fatiga visual durante el uso nocturno
2. **Contraste**: Mejora la legibilidad de la información importante
3. **Ahorro de batería**: En dispositivos con pantallas OLED/AMOLED
4. **Tendencia actual**: Alineación con las tendencias modernas de diseño de aplicaciones

### Interfaz minimalista

El diseño de la interfaz sigue principios minimalistas:

1. **Claridad**: Enfoque en la información esencial
2. **Espaciado**: Uso adecuado del espacio en blanco para mejorar la legibilidad
3. **Jerarquía visual**: Clara distinción entre elementos primarios y secundarios
4. **Consistencia**: Uso coherente de colores, tipografía y componentes

### Feedback visual

Se implementaron varios mecanismos de feedback:

1. **Diálogos**: Para mostrar errores y confirmaciones importantes
2. **Toast**: Para notificaciones breves
3. **Indicadores de carga**: Para operaciones asíncronas
4. **Validación en tiempo real**: Feedback inmediato durante la entrada de datos

## Consideraciones de seguridad

1. **Permisos**: Solicitud explícita de permisos necesarios (ubicación)
2. **Validación de entrada**: Tanto en cliente como en servidor
3. **Manejo de errores**: Sin exponer información sensible en mensajes de error

## Mejoras futuras

1. **Autenticación robusta**: Implementar JWT y almacenamiento seguro de credenciales
2. **Navegación real**: Utilizar la API Directions de Google para rutas reales
3. **Persistencia de datos**: Almacenamiento local con Room o DataStore
4. **Testing**: Implementar tests unitarios, de integración y UI
5. **CI/CD**: Configurar integración y despliegue continuos

## Conclusión

Las decisiones técnicas tomadas en este proyecto se orientaron a crear una aplicación moderna, mantenible y con buena experiencia de usuario, utilizando las mejores prácticas y tecnologías recomendadas para el desarrollo Android actual.

---

Documento elaborado por: Raul Fernando Castaño Arias  
Fecha: Octubre 2025
