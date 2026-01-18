# 🔥 AI Code Scrutinizer

> **"Because your compiler is too polite."**

A Command Line Interface (CLI) tool built with **Java** and **Spring Boot** that uses local Large Language Models (Ollama) to review, critique, and ruthlessly roast your code.

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.1-green?style=for-the-badge&logo=springboot)
![Ollama](https://img.shields.io/badge/AI-Ollama-blue?style=for-the-badge)
![Spring Shell](https://img.shields.io/badge/CLI-Spring_Shell-yellow?style=for-the-badge)

---

## 🧐 What is this?
Most code linters check for syntax errors. **AI Code Scrutinizer** checks for *soul*.

This application integrates a Java Spring Boot backend with a locally running LLM (Codellama) to perform static code analysis with personality. It doesn't just tell you what's wrong; it tells you *how it feels about it*.

### Key Features
* **⚡ Zero Latency / 100% Privacy:** Runs entirely on `localhost` using Ollama. Your code never leaves your machine.
* **🛠️ Spring Shell Integration:** A fully interactive CLI experience with tab completion and built-in help.
* **🎭 Dynamic Personas:** Choose your pain level:
    * **Level 1 (Soft):** Constructive, gentle feedback.
    * **Level 2 (Spicy):** Sarcastic, dry humor.
    * **Level 3 (Emotional Damage):** Ruthless, toxic, 10x-engineer energy.

---

## 🚀 Demo
*(Insert a screenshot or GIF here showing the CLI in action)*
![Recording 2026-01-18 152329](https://github.com/user-attachments/assets/d774bb94-5599-4e8e-9c5a-31f70f5ffbc7)

`> scrut "C:\\MyBadCode.java" 3`

**Sample Output:**
> "Oh, look at this. A nested loop inside a try-catch block? Do you enjoy O(n^2) complexity, or are you just trying to heat up your CPU during winter? This variable naming scheme is a crime against humanity."

---

## 🛠️ Tech Stack
* **Language:** Java 21
* **Framework:** Spring Boot 3.4.1
* **CLI Framework:** Spring Shell 3.4.0
* **AI Engine:** Ollama (running `codellama` or `mistral`)
* **Networking:** Spring `RestClient` (HTTP Interface)
* **Build Tool:** Maven

---

## ⚙️ Installation & Setup

### Prerequisites
1.  **Java 21 SDK** installed.
2.  **Ollama** installed and running. ([Download here](https://ollama.com))

### Step 1: Prepare the AI
Open your terminal and pull the coding model:
```bash
ollama pull codellama

```

*Keep the Ollama app running in the background!*

### Step 2: Clone and Build

```bash
git clone [https://github.com/YourUsername/AI-Code-Scrutinizer.git](https://github.com/YourUsername/AI-Code-Scrutinizer.git)
cd AI-Code-Scrutinizer
./mvnw clean package -DskipTests

```

### Step 3: Run the App

```bash
java -jar target/AI-Code-Scrutinizer-0.0.1-SNAPSHOT.jar

```

---

## 🎮 Usage

Once the application starts, you will enter the interactive shell:

```bash
shell:>

```

### The `scrut` Command

The main command to analyze a file.

**Syntax:**

```bash
scrut <path-to-file> --level <1-3>

```
**Note: Use double back-slash (\\) or a forward slash (/) as '\' is an escape character.**

**Examples:**

1. **Gentle Review:**
```bash
scrut "C:/Projects/Calculator.java" --level 1

```


2. **Full Roast (Default):**
```bash
scrut "C:/Projects/Calculator.java" --level 3

```
3. **Get Help:**
```bash
help scrut

```
---

## 🧠 Architecture

The application follows a Service-Oriented Architecture:

1. **Command Layer (`HelloCmd.java`):** Handles user input via Spring Shell.
2. **Service Layer (`AiClient.java`):** Constructs the prompt based on the selected "Persona Level" and manages the HTTP lifecycle.
3. **DTO Layer (`OllamaRequest.java`):** Serializes Java Objects to JSON for the AI API.

---

## 🔮 Future Improvements

* [ ] Add support for roasting entire folders/projects.
* [ ] Add a "Fix it for me" command that auto-refactors the code.
---

**Author:** Sujoy Sengupta
