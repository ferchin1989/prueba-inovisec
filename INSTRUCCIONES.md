# Instrucciones para ejecutar el proyecto Inovisec

Este documento proporciona instrucciones detalladas para ejecutar el proyecto Inovisec tanto localmente como para generar el archivo APK.

## Ejecutar el proyecto localmente

### Requisitos previos
- Android Studio Hedgehog (2023.1.1) o superior
- Node.js v16.x o superior
- npm v8.x o superior
- Clave API de Google Maps (con APIs de Maps, Places y Directions habilitadas)
- Dispositivo Android con API level 24 (Android 7.0) o superior, o un emulador configurado

### Pasos para ejecutar el backend

1. Abre una terminal y navega al directorio del backend:
```bash
cd back
```

2. Instala las dependencias:
```bash
npm install
```

3. Inicia el servidor:
```bash
npm start
```

El servidor se ejecutará en `http://localhost:3000`. Puedes verificar que está funcionando correctamente accediendo a esta URL en tu navegador, donde deberías ver un mensaje de bienvenida.

### Pasos para ejecutar la aplicación Android

1. Abre Android Studio
2. Selecciona "Open an existing project" y navega hasta la carpeta `android` del proyecto
3. Espera a que Android Studio sincronice el proyecto y descargue las dependencias

4. Configura la clave API de Google Maps:
   - Crea o edita el archivo `local.properties` en la raíz del proyecto Android
   - Añade la siguiente línea con tu clave API:
     ```
     MAPS_API_KEY=tu_clave_api_aqui
     ```

5. Conecta un dispositivo Android o inicia un emulador

6. Haz clic en el botón "Run" en la barra de herramientas de Android Studio

7. Selecciona el dispositivo o emulador donde quieres ejecutar la aplicación y haz clic en "OK"

La aplicación se instalará y ejecutará en el dispositivo seleccionado.

## Generar archivo APK

Para generar un archivo APK que pueda ser instalado en dispositivos Android:

1. En Android Studio, selecciona "Build" > "Build Bundle(s) / APK(s)" > "Build APK(s)"

2. Espera a que el proceso de compilación termine. Android Studio mostrará una notificación cuando la APK esté lista.

3. Haz clic en "locate" en la notificación para abrir la carpeta que contiene el archivo APK

4. El archivo APK se encontrará en:
   ```
   android/app/build/outputs/apk/debug/app-debug.apk
   ```

### Instalación de la APK en un dispositivo Android

1. Transfiere el archivo APK al dispositivo Android (por ejemplo, usando un cable USB, correo electrónico, o servicio de almacenamiento en la nube)

2. En el dispositivo Android, navega hasta la ubicación del archivo APK y tócalo para iniciar la instalación

3. Si es la primera vez que instalas una APK desde esta fuente, es posible que debas habilitar la instalación de aplicaciones de fuentes desconocidas en la configuración de seguridad del dispositivo

4. Sigue las instrucciones en pantalla para completar la instalación

## Solución de problemas comunes

### El servidor backend no se inicia
- Verifica que el puerto 3000 no esté siendo utilizado por otra aplicación
- Asegúrate de haber instalado todas las dependencias con `npm install`

### La aplicación Android no se conecta al backend
- Si estás usando un emulador, asegúrate de que la URL del backend en `AuthRepository.kt` sea `http://10.0.2.2:3000/`
- Si estás usando un dispositivo físico, asegúrate de que el dispositivo y la computadora estén en la misma red y actualiza la URL al IP de tu computadora

### El mapa no se muestra correctamente
- Verifica que has configurado correctamente la clave API de Google Maps en `local.properties`
- Asegúrate de que las APIs de Maps, Places y Directions estén habilitadas en la consola de Google Cloud
- Verifica que el dispositivo tenga conexión a Internet

### Errores de compilación
- Actualiza Android Studio a la última versión
- Sincroniza el proyecto con los archivos Gradle
- Limpia y reconstruye el proyecto (Build > Clean Project, luego Build > Rebuild Project)

## Contacto

Si encuentras algún problema o tienes preguntas, no dudes en contactarme:

Raul Fernando Castaño Arias
rfcpuma09@gmail.com
