/**
 * MapScreen.kt
 * Pantalla del mapa para la aplicación Inovisec
 * 
 * Esta pantalla muestra un mapa de Google Maps con estilo oscuro,
 * permite seleccionar un tipo de vehículo y tiene un botón para iniciar la navegación.
 * 
 * @author Tu Nombre
 * @version 1.0
 * @since 2025-10-14
 */
package com.modrob.inovisec.ui.map

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*
import com.modrob.inovisec.ui.theme.DarkBackground
import com.modrob.inovisec.ui.theme.TealPrimary

/**
 * Composable principal que muestra la pantalla del mapa
 */
@Composable
fun MapScreen() {
    // Estado para el dropdown de vehículos
    var expanded by remember { mutableStateOf(false) }
    var selectedVehicleType by remember { mutableStateOf<String?>(null) }
    
    // Lista de tipos de vehículos disponibles
    val vehicleTypes = listOf("Sedán", "SUV", "Camioneta", "Motocicleta")
    
    // Configuración del mapa de Google Maps
    val context = LocalContext.current
    
    // Ubicación predeterminada (Ciudad de México)
    val defaultLocation = LatLng(19.432608, -99.133209)
    
    // Estado de la cámara del mapa
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultLocation, 15f)
    }
    
    // Manejo de permisos de ubicación
    var hasLocationPermission by remember { mutableStateOf(
        ContextCompat.checkSelfPermission(
            context, 
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    )}
    
    // Launcher para solicitar permisos de ubicación
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted -> 
            hasLocationPermission = isGranted
        }
    )
    
    // Solicitar permisos de ubicación al iniciar la pantalla
    LaunchedEffect(Unit) {
        if (!hasLocationPermission) {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
    
    // Contenedor principal con fondo oscuro
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        // Contenedor del mapa de Google Maps
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp) // Espacio para la barra superior
        ) {
            // Implementación del mapa de Google Maps con estilo oscuro
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(
                    mapType = MapType.NORMAL, // Tipo de mapa estándar
                    isMyLocationEnabled = hasLocationPermission, // Mostrar ubicación del usuario si hay permiso
                    // Estilo de mapa oscuro personalizado
                    mapStyleOptions = MapStyleOptions("""[
                      {
                        "elementType": "geometry",
                        "stylers": [
                          {
                            "color": "#212121"
                          }
                        ]
                      },
                      {
                        "elementType": "labels.text.fill",
                        "stylers": [
                          {
                            "color": "#757575"
                          }
                        ]
                      },
                      {
                        "featureType": "road",
                        "elementType": "geometry.fill",
                        "stylers": [
                          {
                            "color": "#2c2c2c"
                          }
                        ]
                      },
                      {
                        "featureType": "water",
                        "elementType": "geometry",
                        "stylers": [
                          {
                            "color": "#000000"
                          }
                        ]
                      }
                    ]""")
                ),
                // Configuración de la interfaz del mapa
                uiSettings = MapUiSettings(
                    zoomControlsEnabled = false, // Ocultar controles de zoom predeterminados
                    myLocationButtonEnabled = false, // Ocultar botón de ubicación predeterminado
                    mapToolbarEnabled = false, // Ocultar barra de herramientas
                    compassEnabled = false // Ocultar brújula
                )
            ) {
                // Marcador en la ubicación predeterminada
                Marker(
                    state = MarkerState(position = defaultLocation),
                    title = "Ubicación actual"
                )
            }
            
            // Botón flotante para centrar en la ubicación actual
            FloatingActionButton(
                onClick = { 
                    // Aquí se implementaría la lógica para centrar el mapa en la ubicación actual
                    // Por ejemplo: cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                containerColor = TealPrimary,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = "Mi ubicación"
                )
            }
        }
        
        // Barra superior con selector de vehículo y botón IR - ajustada a la imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp) // Altura ajustada para coincidir con la imagen
                .background(Color(0xFF121212)) // Color más oscuro como en la imagen
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Lado izquierdo: Icono y selector de vehículo
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Fila con icono de vehículo - ajustada a la imagen
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            contentDescription = "Vehículo",
                            tint = TealPrimary,
                            modifier = Modifier.size(36.dp) // El doble de grande
                        )
                        
                        Text(
                            text = "Vehículo",
                            style = MaterialTheme.typography.titleMedium, // Texto más grande
                            color = TealPrimary,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(2.dp))
                    
                    // Texto "Tipo de Vehículo Asignado *"
                    Text(
                        text = "Tipo de Vehículo Asignado *",
                        style = MaterialTheme.typography.titleSmall, // Texto más grande
                        color = Color.White
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    // Selector de vehículo con fondo azul oscuro - más grande
                    Button(
                        onClick = { expanded = true },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(56.dp), // El doble de alto
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0A3D62),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            selectedVehicleType ?: "Seleccionar Vehículo",
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge // Texto más grande
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Arrow",
                            tint = Color.White.copy(alpha = 0.7f),
                            modifier = Modifier.size(32.dp) // El doble de grande
                        )
                    }
                    
                    // Menú desplegable
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(200.dp)
                            .background(Color(0xFF1E1E1E))
                    ) {
                        vehicleTypes.forEach { vehicleType ->
                            DropdownMenuItem(
                                text = { 
                                    Text(
                                        vehicleType,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodySmall
                                    ) 
                                },
                                onClick = {
                                    selectedVehicleType = vehicleType
                                    expanded = false
                                }
                            )
                        }
                    }
                }
                
                // Botón IR con estilo turquesa - más grande
                Button(
                    onClick = { /* Aquí iría la lógica para iniciar la navegación */ },
                    enabled = true,
                    modifier = Modifier
                        .width(100.dp) // El doble de ancho
                        .height(140.dp), // El doble de alto
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TealPrimary,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(4.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Flecha horizontal
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
                            contentDescription = "Ir",
                            modifier = Modifier.size(40.dp) // El doble de grande
                        )
                        
                        Spacer(modifier = Modifier.height(4.dp))
                        
                        // Texto IR
                        Text(
                            text = "IR",
                            style = MaterialTheme.typography.headlineSmall, // Texto mucho más grande
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
