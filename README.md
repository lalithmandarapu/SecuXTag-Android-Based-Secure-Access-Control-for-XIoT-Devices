# SecuXTag 
**Android-Based Secure Access Control for XIoT Devices**

SecuXTag is a cybersecurity-focused Android application designed to securely control and interact with XIoT (Extended Internet of Things) devices using BLE, NFC, or Wi-Fi Direct. This project explores end-to-end encryption, device authentication, tamper detection, and access logging—critical concepts in modern IoT security.

---

## Features (Planned)
- 🔐 Encrypted communication using AES
- 🔑 Role-based device access control
- 📶 BLE/NFC communication with simulated XIoT devices
- 📜 Logging of access and tampering attempts
- ⚠️ Real-time alerts for suspicious activity

---

##  Tech Stack
- **Android Studio** (Kotlin/Java)
- **Firebase** or Flask backend
- **AES-256 Encryption**
- **NFC / BLE APIs**
- (Optional) Raspberry Pi or Node.js for XIoT simulation

---

## Contributions (so far)

### 1.  Android App Skeleton
- Created a clean Android Studio project with navigation structure.
- Setup `MainActivity` and initial permissions for BLE and NFC access.

### 2.  AES Encryption Module (Java)
- Implemented basic AES encryption/decryption utility class for securing commands between app and XIoT device.
- Uses AES/GCM/NoPadding with secure key generation.

---

##  Next Milestones
- 🔗 BLE/NFC handshake with simulated device
- 🧪 Device simulator (Python-based)
- 📊 Secure logging and analytics
- 🔓 Tamper detection and Zero Trust validation

---

##  Maintainer
Lalith Mandarapu – B.Tech in Cybersecurity

