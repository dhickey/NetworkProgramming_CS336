# Java Launcher

Simple Windows launcher program for CS336 Homework 1.

## Description

`Launcher` presents a small menu of common Windows executables and starts the selected program. For two options (`nslookup` and `cmd`) the launcher inherits console I/O and waits for the program to exit, reporting CPU time and exit code.

## Requirements

- Java 11+ (or Java 9+ for ProcessHandle API)
- Windows OS (uses Windows executables)

## Build

From the project root run:

```bash
javac -d bin src/Launcher.java
```

## Run

From the project root run:

```bash
java -cp bin Launcher
```

Alternatively, use the precompiled class in `bin/Launcher.class`:

```bash
java -cp bin Launcher
```

## Usage

When run, the program displays a numbered menu. Enter the number for the program to start.

Example options include:

- `0` - Quit
- `1` - Task Manager (`Taskmgr.exe`)
- `2` - Notepad (`notepad.exe`)
- `3` - Character Map (`charmap.exe`)
- `4` - Snipping Tool (`SnippingTool.exe`)
- `5` - Windows version dialog (`winver.exe`)
- `6` - System Information (`msinfo32.exe`)
- `7` - nslookup (console; launcher waits)
- `8` - cmd (console; launcher waits)

## Notes

- Some programs may require elevated privileges. Run the launcher from an elevated prompt if needed.
- This project is provided as-is for course homework purposes.
