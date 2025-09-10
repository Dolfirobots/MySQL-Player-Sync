# 🔄 PlayerSyncer

> [!NOTE]
> Sprachen:  
> _**[Deutsch](./README_DE.md)**_  
> **[English](./README.md)** *(in Arbeit)*

[![License](https://img.shields.io/github/license/Dolfirobots/MySQL-Player-Sync?style=flat-square)](./LICENSE)
[![GitHub Dowloads](https://shields.io/github/downloads/Dolfirobots/MySQL-Player-Sync/total?label=Downloads&logoColor=Green&color=Blue&style=flat)](https://github.com/Dolfirobots/MySQL-Player-Sync/releases)
[![GitHub Release](https://img.shields.io/github/v/release/Dolfirobots/MySQL-Player-Sync?color=Green)](https://github.com/Dolfirobots/OnlyProxy/releases "OnlyProxy Releases")
[![Discord](https://img.shields.io/discord/1079052573845241877.svg?logo=discord&logoColor=Green&color=Blue&labelColor=Green)](https://discord.gg/dxZTGpPbkd "Discord")
[![Database](https://img.shields.io/badge/Database-MySQL%20%7C%20MariaDB-orange?style=flat-square)](#-datenbank-einrichtung)

**PlayerSyncer** ist ein Plugin für **Minecraft Paper (1.21.x)**, mit dem du **Spielerdaten** zuverlässig über mehrere Server hinweg synchronisieren kannst – vollständig NBT-kompatibel und mit API für Drittanbieter-Plugins.

---

## ✨ Features

- ✅ Kompatibel mit **Minecraft Paper 1.21.x**
- ✅ Unterstützt **MySQL** und **MariaDB**
- 🔄 Synchronisiert automatisch:
  - Inventare (mit **vollständiger Item-NBT**)
  - Leben
  - Hunger & Sättigung
  - Schaden
  - Aktive Effekte (Potions)
- 🧩 API zur Integration in eigene Plugins
- 📁 Asynchrone Datenverarbeitung

---

## 📥 Installation

1. Lade die neueste Version von [GitHub](https://github.com/DeinUser/PlayerSyncer/releases) oder Spigot (Coming Soon) herunter.
2. Lege die `.jar`-Datei in deinen Server-Ordner `/plugins/`
3. Starte den Server neu, um die Konfigurationsdateien generieren zu lassen.
4. Richte die Datenbank ein (siehe unten) und passe die Konfigurationsdateien an.
5. Neuladen/Neustarten → Fertig!

---

## ⚙️ Konfiguration

Nach dem ersten Start findest du die Konfigurationsdatein in `/plugins/PlayerSync/`

### Beispiel `config.yml`:

```yaml
database:
  host: localhost
  port: 3306
  name: playersync
  user: sync_user
  password: sicheres_passwort

sync:
  inventory: true
  health: true
  hunger: true
  effects: true
  damage: true
```

---

## 🛠️ Datenbank Einrichtung

### 🧾 SQL-Befehle:

```sql
-- Datenbank erstellen
CREATE DATABASE playersync;

-- Nutzer erstellen
CREATE USER 'sync_user'@'%' IDENTIFIED BY 'sicheres_passwort';

-- Rechte vergeben
GRANT ALL PRIVILEGES ON playersync.* TO 'sync_user'@'%';

-- Rechte anwenden
FLUSH PRIVILEGES;
```

> 🔐 **Hinweis:** Beschränke Zugriffe auf vertrauenswürdige IP-Adressen und verwende sichere Passwörter!

---

## 📚 API Nutzung

`PlayerSyncer` stellt eine einfach zu verwendende API für Entwickler bereit.

### Beispiel (Java):

```java
PlayerSyncAPI api = PlayerSyncer.getAPI();
api.syncNow(Bukkit.getPlayer("Notch"));
```

> 🧩 Weitere Informationen zur API findest du bald im [Wiki](https://github.com/DeinUser/PlayerSyncer/wiki) *(in Arbeit)*.

---

## 📑 Rechte (Permissions)

Aktuell werden keine speziellen Permissions benötigt.
Die API ist offen, benötigt aber keine zusätzlichen Berechtigungen.

---

## 🧪 Kompatibilität

* ✅ Minecraft 1.21.x
* ✅ Paper (Empfohlen)
* ⚠️ Andere Server-Software (z.B. Spigot, Purpur) nicht getestet

---

## 📁 Speicherort der Daten

Alle Daten werden automatisch in deiner konfigurierten Datenbank gespeichert.

---

## 📜 Lizenz

Dieses Projekt ist unter der [MIT License](./LICENSE) lizenziert.
Du darfst es frei verwenden, ändern und weitergeben – auch kommerziell.

---

## 🤝 Mitwirken

* Fehler gefunden? → [Issue erstellen](https://github.com/DeinUser/PlayerSyncer/issues)
* Feature-Wunsch? → Join auf Discord *(falls vorhanden)* oder schreib uns!
* Du möchtest selbst beitragen? → Fork das Repo und sende einen Pull Request

---

💡 **Tipp:** PlayerSyncer eignet sich ideal für Netzwerk-Server, die über Velocity oder BungeeCord miteinander verbunden sind!
