# Hogwarts Legacy – Java Implementation

**Author:** AlexK  
**Course:** Programming 2  
**University:** University of Vienna  
**Semester:** Summer Term 2025

---

## 📘 Project Overview

This project is a full Java implementation of a simplified *Hogwarts Legacy* simulation designed as a Programming 2 university assignment.  
It models **wizards**, **spells**, **potions**, **scrolls**, **trade mechanics**, and **magical combat**.

The project demonstrates:
- Object-oriented programming principles (inheritance, interfaces, encapsulation)
- Exception handling
- Enum usage (`MagicLevel`)
- Class interactions via multiple interfaces
- Use of abstract classes and polymorphism

---

## 🧙‍♂️ Core Components

- **MagicLevel** – Enum defining NOOB → MASTER magic proficiency.
- **MagicSource**, **MagicEffectRealization**, **Trader**, **Tradeable** – Core interfaces defining magic and trade behavior.
- **MagicItem**, **Potion**, **Scroll**, **Concoction** – Hierarchy of magical items.
- **Spell**, **AttackingSpell**, **HealingSpell**, **ProtectingSpell** – Spell hierarchy.
- **Wizard** – Central class representing a living character capable of using, learning, trading, stealing, and looting.

---

## 🧪 Test File

The provided `TestFile.java` thoroughly demonstrates:

- Creation of wizards and spells
- Learning, forgetting, and casting spells
- Potion and scroll usage
- Trading between wizards
- Stealing and looting
- Health and mana effects
- Random spell and item actions
- Handling of protection spells and complex interactions

---

## ⚙️ Compilation & Execution

### 1. Navigate to the project root:
```bash
cd src
```
### 2. Compile
```bash
javac AlexK/*.java
```
### 3. Run
```bash
java AlexK.TestFile
```
