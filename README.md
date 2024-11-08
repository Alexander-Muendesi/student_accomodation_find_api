# Local Project Setup

## Database
- Create a new database in PostgresQL.
- Update the database connection properties in the applicatiom.properties file in the project with your database name and authentication credentials.
- Be sure to give the necessary permissions to your role.
- JPA / Hibernate will automatically create the tables.

## Running project
- Download IntelliJ IDea.
- Clone the repository to your machine.
- Open the project with the IDE and run it.

  
# Requirements

## User Registration and Authentication
- Users can register as a **Student** or as an **Owner**.
- Registered users can log in and authenticate using **session-based authentication**.
- Basic authorization controls:
  - Only **Owners** can create or modify listings.
  - **Students** can browse and book accommodations.

## Accommodation Listings
- Owners can:
  - Create, update, and delete accommodation listings.
- Each listing includes:
  - **Price**, **location**, **room type**, **amenities**, and **availability status**.
- Listings are searchable by criteria:
  - **Location**, **price range**, **amenities**, etc.

## Booking System
- Students can book available accommodations.
- Bookings include:
  - **Start date**, **end date**, and **status** (e.g., pending, confirmed, completed).
- Owners can:
  - Accept or reject booking requests.

## Review System
- Students can leave reviews for accommodations they’ve stayed in.
- Reviews include:
  - A **rating** and a **description**, visible on the listing.

## Session Management and Security
- Ensure secure session handling with **tokens** or **cookies**.
- Use **role-based authorization** to restrict access to certain endpoints.
