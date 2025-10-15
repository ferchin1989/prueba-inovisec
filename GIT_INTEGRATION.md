# Integración con Git

Este documento explica cómo se ha configurado y cómo se debe utilizar Git para el control de versiones de este proyecto.

## Estructura del repositorio

El repositorio está organizado de la siguiente manera:

```
prueba-inovisec/
├── android/          # Aplicación Android con Kotlin y Jetpack Compose
├── back/             # Servidor backend con Node.js y Express
├── docs/             # Documentación adicional
├── .gitignore        # Archivos y directorios ignorados por Git
├── README.md         # Documentación principal del proyecto
└── INSTRUCCIONES.md  # Instrucciones para ejecutar el proyecto
```

## Configuración inicial

Para configurar el repositorio Git por primera vez:

1. Inicializar el repositorio:
```bash
git init
```

2. Añadir el archivo `.gitignore`:
```bash
# Archivos y directorios de Node.js
node_modules/
npm-debug.log
yarn-error.log
.env

# Archivos y directorios de Android
*.iml
.gradle/
/local.properties
/.idea/
.DS_Store
/build/
/captures/
.externalNativeBuild/
.cxx/
*.apk
*.aab
output.json

# Archivos generados
*.log
*.tmp
```

3. Realizar el primer commit:
```bash
git add .
git commit -m "Commit inicial: Estructura básica del proyecto"
```

## Flujo de trabajo con Git

Para este proyecto, se recomienda seguir el flujo de trabajo Git Flow:

### Ramas principales

- **main**: Contiene el código de producción estable

## Comandos Git comunes

### Crear una nueva rama para una característica

```bash
git checkout develop
git checkout -b feature/nombre-caracteristica
```

### Realizar commits

```bash
git add .
git commit -m "Descripción clara del cambio realizado"
```

### Fusionar una característica completada

```bash
git checkout develop
git merge --no-ff feature/nombre-caracteristica
git branch -d feature/nombre-caracteristica
```

### Preparar una versión para producción

```bash
git checkout develop
git checkout -b release/v1.0.0
# Realizar ajustes finales si es necesario
git checkout main
git merge --no-ff release/v1.0.0
git tag -a v1.0.0 -m "Versión 1.0.0"
git checkout develop
git merge --no-ff release/v1.0.0
git branch -d release/v1.0.0
```

## Integración con GitHub

Para compartir el repositorio en GitHub:

1. Crear un nuevo repositorio en GitHub

2. Añadir el repositorio remoto:
```bash
git remote add origin https://github.com/usuario/prueba-inovisec.git
```

3. Subir el código al repositorio remoto:
```bash
git push -u origin main
git push -u origin develop
```

## Buenas prácticas

1. **Commits frecuentes**: Realizar commits pequeños y frecuentes que representen cambios lógicos completos
2. **Pull antes de push**: Siempre hacer `git pull` antes de `git push` para evitar conflictos
3. **Revisión de código**: Utilizar pull requests para revisión de código antes de fusionar en ramas principales
4. **Mensajes descriptivos**: Escribir mensajes de commit claros y descriptivos
5. **No subir secretos**: Nunca subir claves API, contraseñas u otra información sensible al repositorio

---

Documento elaborado por: Raul Fernando Castaño Arias  
Fecha: Octubre 2025
