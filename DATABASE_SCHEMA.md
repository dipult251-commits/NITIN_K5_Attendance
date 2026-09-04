# Attendance Database Schema

## Table: attendance_table

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| date | TEXT | PRIMARY KEY | Date in YYYY-MM-DD format |
| day | TEXT | NOT NULL | Day of the week |
| status | TEXT | NOT NULL | PRESENT, ABSENT, or LEAVE |
| markedTime | TEXT | NOT NULL | Time marked in HH:mm:ss format |
| timestamp | LONG | NOT NULL | Unix timestamp |

## Queries

- Get attendance for a specific date
- Get all attendance records (ordered by date)
- Get attendance for a specific month
- Count present/absent/leave records
- Delete all records
