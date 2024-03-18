
# Money Forker

a "simple" expense tracker. See design [here](https://www.figma.com/file/ohtSEI3g697SPda3hyGIYz/Money-Forker-App?type=design&node-id=308-66&mode=design&t=8Tyeo5wvEy2I8HyJ-0).

## Requirements

- Store data in **local** db
- Take in expenses (with different categories)
- Take in income (from different places)
- Simple graphing of (expenses and income)
- Simple budget generator (v2)
## DB Structure

|    | def         |
|----|-------------|
| PK | Primary Key |
| FK | Foreign Key |
| NN | Not Null    |

### Category
- id (UUID) PK
- name (VARCHAR) NN

### AccountType
- id (UUID) PK
- name (VARCHAR) NN

### Accounts
- id (UUID) PK
- description (VARCHAR)
- amount (MONEY/INT) NN
- type (UUID) FK AccountType NN
- category (UUID) FK Category NN
