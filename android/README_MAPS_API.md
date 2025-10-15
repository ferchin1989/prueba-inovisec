# Configuración de la API de Google Maps

Este documento explica paso a paso cómo configurar la API de Google Maps para que funcione correctamente con la aplicación.

## 1. Crear una cuenta de Google Cloud Platform

1. Ve a [Google Cloud Console](https://console.cloud.google.com/)
2. Crea una cuenta si no tienes una
3. Crea un nuevo proyecto desde el menú desplegable en la parte superior

## 2. Habilitar las APIs necesarias

1. En la consola, ve a "APIs y servicios" > "Biblioteca"
2. Busca y habilita las siguientes APIs:
   - Maps SDK for Android
   - Places API (si necesitas búsqueda de lugares)
   - Directions API (si necesitas rutas)

## 3. Crear credenciales

1. Ve a "APIs y servicios" > "Credenciales"
2. Haz clic en "Crear credenciales" > "Clave de API"
3. Se generará una nueva clave de API. Cópiala.
4. Haz clic en "Restringir clave" para configurar restricciones:
   - En las restricciones de aplicación, selecciona "Aplicaciones Android"
   - Añade el nombre del paquete de la aplicación: `com.modrob.inovisec`
   - Añade la huella digital SHA-1 de tu certificado de desarrollo

## 4. Obtener la huella digital SHA-1

### En Windows:
```
cd %USERPROFILE%\.android
keytool -list -v -keystore debug.keystore -alias androiddebugkey -storepass android -keypass android
```

### En macOS/Linux:
```
cd ~/.android/
keytool -list -v -keystore debug.keystore -alias androiddebugkey -storepass android -keypass android
```

## 5. Configurar la clave en la aplicación

1. Crea o edita el archivo `local.properties` en la raíz del proyecto
2. Añade la siguiente línea:
```
MAPS_API_KEY=tu_clave_api_aqui
```
3. Reemplaza `tu_clave_api_aqui` con la clave que generaste en el paso 3

## 6. Verificar la configuración

1. Asegúrate de que el archivo AndroidManifest.xml contiene la meta-data para la API key:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="${MAPS_API_KEY}" />
```

2. Asegúrate de que el archivo build.gradle.kts incluye el plugin de secrets-gradle-plugin:
```kotlin
plugins {
    // Otros plugins...
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
}
```

3. Asegúrate de que las dependencias de Google Maps están incluidas:
```kotlin
// Google Maps
implementation("com.google.maps.android:maps-compose:2.15.0")
implementation("com.google.android.gms:play-services-maps:18.2.0")
implementation("com.google.android.gms:play-services-location:21.0.1")
```

## 7. Problemas comunes

- **El mapa aparece en gris o con una cuadrícula**: La clave API no es válida o no está correctamente configurada
- **Error "API key not found"**: Verifica que la clave está correctamente configurada en local.properties
- **Permisos de ubicación**: Asegúrate de que la aplicación solicita los permisos necesarios en tiempo de ejecución

## 8. Recursos adicionales

- [Documentación oficial de Google Maps para Android](https://developers.google.com/maps/documentation/android-sdk/overview)
- [Documentación de Maps Compose](https://developers.google.com/maps/documentation/android-sdk/maps-compose)
- [Estilos de mapas](https://mapstyle.withgoogle.com/)
