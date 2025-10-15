# Entrega Final - Prueba Técnica Inovisec

Este documento proporciona instrucciones para la entrega final del proyecto desarrollado como parte de la prueba técnica para Inovisec.

# Contenido de la entrega

La entrega incluye los siguientes componentes:

1. **Código fuente completo**:
   - Aplicación Android desarrollada con Kotlin y Jetpack Compose
   - Servidor backend desarrollado con Node.js y Express.js

2. **Documentación**:
   - `README.md`: Visión general del proyecto, tecnologías y requisitos
   - `INSTRUCCIONES.md`: Guía detallada para ejecutar el proyecto y generar APK
   - `DECISIONES_TECNICAS.md`: Explicación de decisiones de diseño y arquitectura
   - `ESTRUCTURA_PROYECTO.md`: Descripción de la estructura de directorios y componentes
   - `GIT_INTEGRATION.md`: Guía para la integración con Git y flujo de trabajo
   - `VERIFICACION_REQUISITOS.md`: Verificación del cumplimiento de todos los requisitos
   - `README_MAPS_API.md`: Instrucciones específicas para configurar Google Maps API

3. **APK de la aplicación**:
   - Ubicación: `android/app/build/outputs/apk/debug/app-debug.apk`
   - Generada siguiendo las instrucciones en `INSTRUCCIONES.md`

# Pasos para la entrega

# 1. Verificación final

Antes de la entrega, se ha verificado que:

- Todos los requisitos están implementados (ver `VERIFICACION_REQUISITOS.md`)
- La aplicación se ejecuta correctamente en dispositivos Android
- El servidor backend responde adecuadamente a las solicitudes
- La documentación está completa y actualizada
- El código incluye comentarios explicativos

# 2. Generación de APK

Se ha generado el archivo APK siguiendo estos pasos:

1. Abrir el proyecto en Android Studio
2. Seleccionar "Build" > "Build Bundle(s) / APK(s)" > "Build APK(s)"
3. El archivo APK se encuentra en `android/app/build/outputs/apk/debug/app-debug.apk`

# 3. Compartir el repositorio

El código fuente completo se ha subido a un repositorio Git público:

1. Se creó un repositorio en GitHub
2. Se subió el código con los siguientes comandos:
   ```bash
   git init
   git add .
   git commit -m "Entrega inicial: Prueba técnica Inovisec"
   git branch -M main
   git remote add origin https://github.com/raulfernandocastano/prueba-inovisec.git
   git push -u origin main
   ```

3. El repositorio está disponible en: [https://github.com/raulfernandocastano/prueba-inovisec](https://github.com/raulfernandocastano/prueba-inovisec)

# Credenciales de prueba

Para probar la aplicación, se pueden utilizar las siguientes credenciales:

- **Email**: usuario@ejemplo.com
- **Contraseña**: 123456

## Contacto

Para cualquier consulta o aclaración sobre la entrega, por favor contactar a:

Raul Fernando Castaño Arias  
Email: rfcpuma09@gmail.com
Teléfono: 3044575377

---

Fecha de entrega: Octubre 2025
