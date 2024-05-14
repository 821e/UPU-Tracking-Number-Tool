## Tracking Number Generator and Checker

This Java application serves as a UPU (Universal Postal Union) Tracking Number Generator and Checker, providing functionality to both generate and verify tracking numbers based on user input. It's designed to be user-friendly and efficient for various postal services adhering to the UPU standards.

### Features

- **Tracking Number Generation**: 
  - Users can select a service provider from a dropdown menu.
  - Input fields allow users to specify country code, service indicator, starting number, and quantity of tracking numbers to generate.
  - Generates tracking numbers adhering to a specific format.

- **Tracking Number Verification**: 
  - Validates generated tracking numbers to ensure correctness.
  - Verifies format and checksum rules.
  - Provides information about the associated country and service indicator.

### Usage

1. **Generate Tracking Numbers**:
   - Select a service provider from the dropdown menu.
   - Enter the country code, service indicator, starting number (first 8 digits), and the quantity of tracking numbers to generate.
   - Click the "Generate" button.

2. **Verify Tracking Numbers**:
   - Click the "Verify" button to check the validity of generated tracking numbers.
   - View verification results and associated information in the result area.

### Key Components

- **Service Selector**: Allows for easy selection of service providers, automatically filling in relevant fields.
- **Checksum Calculation**: Ensures the integrity and validity of generated tracking numbers.
- **Country Information Lookup**: Provides details about the country associated with each tracking number.
- **Error Handling**: Alerts users to incorrect input formats or non-numeric quantities.

### Execution

To run the application, execute the `main` method, which initializes the Swing GUI and makes the application visible.

### Requirements

- Java Development Kit (JDK) installed on your system.

### Contributing

Contributions are welcome! Feel free to submit issues or pull requests.
