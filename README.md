# Java Calculator Application

A modern, feature-rich calculator application built using Java Swing, offering a clean and intuitive user interface with a professional design inspired by modern calculator apps.

## Features

- **Modern UI Design**: Black theme with orange operator buttons and a clean layout
- **Basic Arithmetic Operations**:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (×)
  - Division (÷)
- **Additional Functionality**:
  - Decimal point support for floating-point calculations
  - Delete (DEL) button to remove the last entered digit
  - All Clear (AC) button to reset the calculator
  - Error handling for division by zero
  - Support for negative numbers
  - Automatic formatting of results (removes unnecessary decimal places for whole numbers)

## Technical Implementation

The calculator is implemented using:
- Java Swing for the GUI components
- Custom styling with modern color schemes
- Event-driven architecture using ActionListener
- Grid layout for button organization
- Robust error handling and input validation

### Key Components

- **Display**: A non-editable text field with right-aligned text
- **Number Pad**: Digits 0-9 arranged in a familiar calculator layout
- **Operator Buttons**: Distinctively colored orange buttons for arithmetic operations
- **Function Buttons**: Clear and delete functionality for error correction
- **Equal Button**: Performs calculations and displays results

## Project Structure

The workspace is organized as follows:
- `src/`: Contains the source code files
  - `Calculator.java`: Main implementation file
- `lib/`: For managing dependencies (if any)
- `bin/`: Contains compiled output files

## How to Run

1. Ensure you have Java Development Kit (JDK) installed
2. Navigate to the project directory
3. Compile the source code:
   ```bash
   javac src/Calculator.java
   ```
4. Run the application:
   ```bash
   java -cp src Calculator
   ```

## Implementation Details

The calculator implements a clean object-oriented design with:
- Proper event handling for button clicks
- State management for operations
- Input validation and error handling
- Memory management for storing previous calculations
- Responsive UI with professional styling

## Future Enhancements

Potential areas for future development:
- Scientific calculator functions
- History of calculations
- Keyboard input support
- Memory functions (M+, M-, MR, MC)
- Additional themes and customization options
