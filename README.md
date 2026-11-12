# AuditPrism

**A Java-Based Audit Data Analysis Project**

AuditPrism is an open-source Java project designed to explore how programming can support financial auditing and transaction analysis.

Drawing on an auditing background, this project combines practical audit-related problems with fundamental Java programming concepts. Its long-term goal is to develop a lightweight, transparent, and extensible tool for identifying potentially unusual financial transactions.

## Current Version: v0.3

Version 0.3 builds on the existing transaction summary and duplicate detection functionality by introducing rule-based audit risk scoring, risk classification, and prioritized transaction reporting.

The application now allows users to identify potentially duplicate transactions, assign risk scores based on predefined indicators, and prioritize transactions for further audit review.

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

Additional improvements:
- Skip empty or malformed CSV records.
- Identify transaction pairs that trigger duplicate detection rules.
- Display the rules triggered by each pair.

### Audit Risk Scoring (v0.3)

Introduces a rule-based scoring system to prioritize transactions for further review.

Each transaction receives a risk score based on the following rules:

| Risk Indicator | Points |
|---|---:|
| Same vendor, invoice number, and amount | 40 |
| Same vendor, amount, and date | 30 |
| Same transaction ID | 20 |
| Transaction amount greater than $5,000 | 10 |

Each rule contributes points at most once per transaction, regardless of how many other transactions match.

The total risk score ranges from 0 to 100.

#### Risk Classification

| Risk Score | Risk Level |
|---|---|
| 60–100 | HIGH |
| 30–59 | MEDIUM |
| 0–29 | LOW |

#### Risk Reporting

- Calculate a risk score for each transaction.
- Classify transactions into HIGH, MEDIUM, and LOW risk levels.
- Sort transactions by risk score in descending order.
- Display a transaction-level audit risk report.
- Summarize the number of transactions in each risk category.

**Note:** The detection results indicate potential anomalies requiring further audit investigation. They do not establish confirmed duplicate payments or fraud.

## Project Structure

AuditPrism/
├── src/
│   ├── AuditApp.java
│   ├── Transaction.java
│   ├── DuplicateDetector.java
│   ├── RiskScorer.java
│   └── RiskComparator.java
├── data/
│   └── transactions.csv
├── README.md
├── LICENSE
└── .gitignore

- **AuditApp.java** — Main application for importing CSV data, calculating summary statistics, and running duplicate detection.
- **Transaction.java** — Represents an individual financial transaction.
- **DuplicateDetector.java** — Implements rule-based duplicate transaction detection.
- **RiskScorer.java** — Calculates transaction-level risk scores and determines risk classifications based on predefined rules.
- **RiskComparator.java** — Implements `Comparator<Transaction>` to sort transactions by risk score in descending order.
- **transactions.csv** — Sample transaction data for testing.

## Technologies and Concepts

- Java
- Object-oriented programming
- Classes and objects
- Encapsulation and getter/setter methods
- `ArrayList` and Java Collections
- Generics and `Comparator`
- File input using CSV data
- Loops and conditional statements
- Methods and Boolean logic
- Sorting and data processing

## How to Run

1. Install a compatible Java Development Kit (JDK) and Eclipse IDE.
2. Download or clone this repository.
3. Import the project into Eclipse as a Java project.
4. Open `src/AuditApp.java`.
5. Make sure the sample CSV file is available at `data/transactions.csv`.
6. Run `AuditApp.java` as a Java Application.

The program reads the sample transaction data and displays summary statistics in the Eclipse Console.

## Development Roadmap

| Version | Planned Features                                   		   | Status    |
| ------- | -----------------------------------------------------------| --------- |
| v0.1    | CSV import and transaction summary                         | Completed |
| v0.2    | Rule-based duplicate transaction detection                 | Completed |
| v0.3 	  | Audit risk scoring, classification, sorting, and reporting | Completed |


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
**v0.3** — Introduced transaction-level risk scoring and reporting.