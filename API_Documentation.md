# Roadster API Documentation

## Overview
This is the API documentation for the Roadster Spring Boot application. The application provides various endpoints for managing areas, crimes, crosswalks, drivers, locations, police stations, traffic data, and real-time location tracking via WebSocket.

**Base URL:** `http://localhost:8080`  
**Production URL (via ngrok):** `https://8569284e503d.ngrok-free.app`

---

## Table of Contents
1. [Areas API](#areas-api)
2. [Crime Data API](#crime-data-api)
3. [Crosswalk API](#crosswalk-api)
4. [Driver API](#driver-api)
5. [Location API](#location-api)
6. [Phone Location & WebSocket API](#phone-location--websocket-api)
7. [Police Station API](#police-station-api)
8. [Reports API](#reports-api)
9. [Traffic API](#traffic-api)
10. [WebSocket Configuration](#websocket-configuration)
11. [Error Handling](#error-handling)

---

## Areas API

### Get All Areas
Retrieves all areas with their crime rates, congestion levels, and associated police station information.

**Endpoint:** `GET /api/areas`

**Response:**
```json
[
  {
    "area_id": 1,
    "name": "Downtown",
    "crime_rate": 15.5,
    "congestion_level": 8.2,
    "radius": 2.5,
    "Pstation_id": 1
  }
]
```

**Response Fields:**
- `area_id` (integer): Unique identifier for the area
- `name` (string, nullable): Name of the area
- `crime_rate` (double, nullable): Crime rate percentage in the area
- `congestion_level` (double, nullable): Traffic congestion level (0-10 scale)
- `radius` (double, nullable): Radius of the area in kilometers
- `Pstation_id` (integer, nullable): Associated police station ID

---

## Crime Data API

### Get Crime Counts by District
Retrieves crime statistics grouped by district.

**Endpoint:** `GET /api/crimes/by-district`

**Response:**
```json
[
  {
    "district": "Chittagong",
    "crimeCount": 45
  },
  {
    "district": "Dhaka",
    "crimeCount": 78
  }
]
```

**Response Fields:**
- `district` (string): Name of the district
- `crimeCount` (integer): Total number of crimes reported in the district

---

## Crosswalk API

### Get Crosswalk Status by District
Retrieves the status of crosswalks in a specific district.

**Endpoint:** `GET /api/crosswalks/{district}`

**Path Parameters:**
- `district` (string): Name of the district

**Example:** `GET /api/crosswalks/Chittagong`

**Response:**
```json
[
  {
    "crosswalkId": 1,
    "location": "Main Street & 1st Avenue",
    "status": "ACTIVE",
    "lastMaintenance": "2025-08-15"
  }
]
```

**Response Fields:**
- `crosswalkId` (integer): Unique identifier for the crosswalk
- `location` (string): Description of crosswalk location
- `status` (string): Current status (ACTIVE, INACTIVE, MAINTENANCE)
- `lastMaintenance` (string): Date of last maintenance

---

## Driver API

### Get All Drivers
Retrieves information about all registered drivers.

**Endpoint:** `GET /api/drivers`

**Response:**
```json
[
  {
    "driverId": 1,
    "name": "John Doe",
    "licenseNumber": "DL-2024-001",
    "vehicleAssigned": "CAR-001",
    "status": "AVAILABLE",
    "currentLocation": {
      "latitude": 22.4638383,
      "longitude": 91.9703885
    }
  }
]
```

**Response Fields:**
- `driverId` (integer): Unique identifier for the driver
- `name` (string): Driver's full name
- `licenseNumber` (string): Driver's license number
- `vehicleAssigned` (string): Assigned vehicle identifier
- `status` (string): Current status (AVAILABLE, BUSY, OFFLINE)
- `currentLocation` (object): Current GPS coordinates

---

## Location API

### Get All Locations
Retrieves all stored location data.

**Endpoint:** `GET /api/locations`

**Response:**
```json
[
  {
    "locationId": 1,
    "name": "Central Plaza",
    "latitude": 22.4638383,
    "longitude": 91.9703885,
    "type": "LANDMARK",
    "description": "Main city center plaza"
  }
]
```

**Response Fields:**
- `locationId` (integer): Unique identifier for the location
- `name` (string): Name of the location
- `latitude` (double): GPS latitude coordinate
- `longitude` (double): GPS longitude coordinate
- `type` (string): Type of location (LANDMARK, STATION, etc.)
- `description` (string): Additional description

---

## Phone Location & WebSocket API

### Real-time Location Updates via WebSocket
For real-time location tracking from mobile devices.

**WebSocket Endpoint:** `wss://8569284e503d.ngrok-free.app/ws`

**STOMP Destination:** `/app/location`
**Subscribe Topic:** `/topic/locations`

#### Send Location (WebSocket)
Send location data via STOMP protocol.

**STOMP Frame:**
```
SEND
destination:/app/location
content-type:application/json

{
  "userId": "android_user_001",
  "latitude": 22.4638383,
  "longitude": 91.9703885,
  "accuracy": 5.0,
  "speed": 15.5,
  "bearing": 45.0,
  "timestamp": 1694284863000
}
```

### Alternative REST Endpoints

#### Update Location (REST)
Alternative HTTP endpoint for location updates.

**Endpoint:** `POST /api/location`

**Request Body:**
```json
{
  "userId": "android_user_001",
  "latitude": 22.4638383,
  "longitude": 91.9703885,
  "accuracy": 5.0,
  "speed": 15.5,
  "bearing": 45.0,
  "timestamp": 1694284863000
}
```

**Response:**
```json
{
  "userId": "android_user_001",
  "latitude": 22.4638383,
  "longitude": 91.9703885,
  "accuracy": 5.0,
  "speed": 15.5,
  "bearing": 45.0,
  "timestamp": 1694284863000
}
```

#### Test Location Service
Simple test endpoint to verify the location service is running.

**Endpoint:** `GET /api/location/test`

**Response:**
```
Location service is running!
```

**PhoneLocation Fields:**
- `userId` (string): Unique identifier for the user/device
- `latitude` (double): GPS latitude coordinate
- `longitude` (double): GPS longitude coordinate
- `accuracy` (double): GPS accuracy in meters
- `speed` (double): Speed in m/s
- `bearing` (double): Direction in degrees (0-360)
- `timestamp` (long): Unix timestamp in milliseconds

---

## Police Station API

### Get All Police Stations
Retrieves information about all police stations.

**Endpoint:** `GET /api/police-stations`

**Response:**
```json
[
  {
    "stationId": 1,
    "name": "Chawkbazar Police Station",
    "contactInfo": "03128-60133",
    "lmgrcCode": "CTG-001"
  }
]
```

### Get Police Stations with Districts
Retrieves police stations along with their district information.

**Endpoint:** `GET /api/police-stations/with-districts`

**Response:**
```json
[
  [
    "Chawkbazar Police Station",
    "Chittagong",
    "03128-60133"
  ]
]
```

**Response Fields:**
- `stationId` (integer): Unique identifier for the police station
- `name` (string): Name of the police station
- `contactInfo` (string): Contact phone number
- `lmgrcCode` (string): Local management code

---

## Reports API

### Get Reports by District
Retrieves report counts for a specific district.

**Endpoint:** `GET /api/reports/{district}`

**Path Parameters:**
- `district` (string): Name of the district

**Example:** `GET /api/reports/Chittagong`

**Response:**
```json
[
  {
    "reportType": "TRAFFIC_VIOLATION",
    "count": 25,
    "district": "Chittagong"
  },
  {
    "reportType": "ACCIDENT",
    "count": 12,
    "district": "Chittagong"
  }
]
```

**Response Fields:**
- `reportType` (string): Type of report
- `count` (integer): Number of reports
- `district` (string): District name

---

## Traffic API

### Get Traffic Levels by District
Retrieves traffic congestion data for a specific district.

**Endpoint:** `GET /api/traffic/{district}`

**Path Parameters:**
- `district` (string): Name of the district

**Example:** `GET /api/traffic/Chittagong`

**Response:**
```json
[
  {
    "area": "Commercial Area",
    "trafficLevel": 7.5,
    "status": "HEAVY",
    "lastUpdated": "2025-09-13T14:30:00"
  }
]
```

**Response Fields:**
- `area` (string): Specific area within the district
- `trafficLevel` (double): Traffic level on a scale of 0-10
- `status` (string): Traffic status (LIGHT, MODERATE, HEAVY, SEVERE)
- `lastUpdated` (string): Timestamp of last update

---

## WebSocket Configuration

### Connection Details
**WebSocket URL:** `wss://8569284e503d.ngrok-free.app/ws`

### STOMP Protocol
The application uses STOMP (Simple Text Oriented Messaging Protocol) over WebSocket for real-time communication.

#### Connection Frame
```
CONNECT
accept-version:1.1,1.0
heart-beat:10000,10000
```

#### Subscription Frame
```
SUBSCRIBE
id:sub-0
destination:/topic/locations
```

#### Sending Messages
```
SEND
destination:/app/location
content-type:application/json

{location_data}
```

### Android Integration
For Android applications, use the WebSocket URL:
```
wss://8569284e503d.ngrok-free.app/ws
```

Send location data to destination: `/app/location`
Subscribe to updates on: `/topic/locations`

---

## Error Handling

### Common HTTP Status Codes
- `200 OK`: Request successful
- `400 Bad Request`: Invalid request parameters
- `404 Not Found`: Resource not found
- `500 Internal Server Error`: Server error

### Error Response Format
```json
{
  "timestamp": "2025-09-13T14:30:00.000+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Cannot invoke \"java.lang.Double.doubleValue()\" because \"<parameter>\" is null",
  "path": "/api/areas"
}
```

### WebSocket Error Codes
- `1002`: Protocol error (invalid endpoint)
- `1006`: Abnormal closure
- `1011`: Server error

---

## Testing the APIs

### Using cURL

#### Test Areas API
```bash
curl -X GET "https://8569284e503d.ngrok-free.app/api/areas"
```

#### Test Police Stations API
```bash
curl -X GET "https://8569284e503d.ngrok-free.app/api/police-stations"
```

#### Test Location Update (REST)
```bash
curl -X POST "https://8569284e503d.ngrok-free.app/api/location" \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "test_user",
    "latitude": 22.4638383,
    "longitude": 91.9703885,
    "accuracy": 5.0,
    "speed": 0.0,
    "bearing": 0.0
  }'
```

### Using Browser
You can test GET endpoints directly in your browser:
- Areas: `https://8569284e503d.ngrok-free.app/api/areas`
- Police Stations: `https://8569284e503d.ngrok-free.app/api/police-stations`
- Location Test: `https://8569284e503d.ngrok-free.app/api/location/test`

---

## Notes

1. **CORS**: The application has CORS enabled for cross-origin requests.

2. **Database**: The application uses MySQL database named "roadster".

3. **WebSocket**: Real-time location updates are broadcasted to all connected clients.

4. **Nullable Fields**: Most fields in the database are nullable, so responses may contain null values.

5. **ngrok URL**: The ngrok URL (`https://8569284e503d.ngrok-free.app`) is temporary and changes when ngrok is restarted.

6. **Development**: For local development, use `http://localhost:8080` as the base URL.

---

## Contact
For questions or issues with the API, please contact the development team.

Last Updated: September 13, 2025
