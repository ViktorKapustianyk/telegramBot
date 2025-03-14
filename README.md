# Telegram Bot in Java

This project is a simple Telegram bot developed in Java that implements a two-level menu.

## Functionality
- The `/start` command displays the main menu with three buttons:
    - **Button 1** — sends the message "Button 1"
    - **Button 2** — sends the message "Button 2"
    - **Next** — navigates to the second menu

- The second menu also contains three buttons:
    - **Button 1** — sends the message "Button 1"
    - **Button 2** — sends the message "Button 2"
    - **Back** — returns to the main menu

## Installation and Launch

### 1. Clone the repository
```bash
git clone <repository URL>
cd <project folder>
```

### 2. Install dependencies
The project uses the **telegrambots** library. Ensure the following dependency is added to `pom.xml` (Maven):

**Maven:**
```xml
<dependency>
    <groupId>org.telegram</groupId>
    <artifactId>telegrambots</artifactId>
    <version>6.1.0</version>
</dependency>
```

### 3. Set Bot Token
In the `.env` file add the following line:
```
YOUR_BOT_TOKEN=your-telegram-bot-token-here
```

### 4. Launch the Project
- Open the project in IntelliJ IDEA or another IDE.
- Run `Main.java`.

