# AuditPrism

**A Java-Based Audit Data Analysis Project**

AuditPrism is an open-source Java project designed to explore how programming can support financial auditing and transaction analysis.

Drawing on an auditing background, this project combines practical audit-related problems with fundamental Java programming concepts. Its long-term goal is to develop a lightweight, transparent, and extensible tool for identifying potentially unusual financial transactions.

## Current Version: v0.2

Version 0.2 extends the initial transaction summary functionality by introducing rule-based detection of potentially duplicate transactions.

### Features
### Basic transaction summary (v0.1)
AuditPrism provides basic transaction summary for users:
- Read transaction records from a CSV file.
- Represent individual transactions using a Java class.
- Store and process transaction data.
- Calculate the total transaction amount.
- Calculate the largest and average transaction amount.
- Count the number of transactions above $5000.

### Duplicate Transaction Detection (v0.2)
AuditPrism identifies potential duplicate transaction pairs using three rules:
- Matching vendor, invoice number, and amount.
- Matching vendor, amount, and date.
- Matching transaction ID.
- Report flagged transaction pairs and explains which rules were triggered.

**Note:** The detection results indicate potential anomalies requiring further audit investigation. They do not establish confirmed duplicate payments or fraud.

## Project Structure

AuditPrism/
├── src/
│   ├── AuditApp.java
│   ├── Transaction.java
│   └── DuplicateDetector.java
├── data/
│   └── transactions.csv
├── README.md
├── LICENSE
└── .gitignore

- **AuditApp.java** — Main application for importing CSV data, calculating summary statistics, and running duplicate detection.
- **Transaction.java** — Represents an individual financial transaction.
- **DuplicateDetector.java** — Implements rule-based duplicate transaction detection.
- **transactions.csv** — Sample transaction data for testing.

## Technologies and Concepts

- Java
- Object-oriented programming
- Classes and objects
- ArrayList and data processing
- File input using CSV data
- Loops and conditional statements
- Basic numerical calculations and formatted output

## How to Run

1. Install a compatible Java Development Kit (JDK) and Eclipse IDE.
2. Download or clone this repository.
3. Import the project into Eclipse as a Java project.
4. Open `src/AuditApp.java`.
5. Make sure the sample CSV file is available at `data/transactions.csv`.
6. Run `AuditApp.java` as a Java Application.

The program reads the sample transaction data and displays summary statistics in the Eclipse Console.

## Development Roadmap

| Version | Planned Features                                   | Status    |
| ------- | -------------------------------------------------- | --------- |
| v0.1    | CSV import and transaction summary                 | Completed |
| v0.2    | Rule-based duplicate transaction detection         | Completed |


## Project Motivation

Financial auditing involves examining transaction records, identifying irregularities, and evaluating potential risks.

This project explores how fundamental programming techniques can be applied to these tasks. It also serves as a practical exercise in software development, version control, and reproducible data analysis.

AuditPrism is intended as an educational project rather than a substitute for professional audit judgment or established audit software.

## Data Disclaimer

The sample dataset is intended for educational and testing purposes. No confidential client information should be uploaded to this public repository.

## Author

Peiheng Wang

## Version History

**v0.1** — Initial working version featuring CSV data import and transaction summary calculations.
**v0.2** — This version identifies potential duplicate transaction pairs using given rules.
