# Sports Center Management System

## Overview

The Sports Center Management System is a Java-based application designed to facilitate the management and booking of services at a sports center. The application allows users to book various facilities, such as gyms and tennis courts, and includes features like service customization and reservation handling.

## Project Structure

The project consists of several key classes that handle different aspects of the system:

## Core Classes

- BaseBooking.java: Provides the foundation for handling bookings.
  
- Booking.java: Extends the base booking functionality to include additional details.
  
- Client.java: Represents the clients of the sports center, including their details and interactions.

## Facilities and Services

- Gym.java: Manages information related to the gym facilities.
  
- TennisCourt.java: Handles tennis court details and operations.
  
- WellnessCenter.java: Represents the wellness center within the sports facility.

## Service Management

- Service.java: Defines the core attributes and behaviors of a service.
  
- ConcreteServiceFactory.java: Implements the factory pattern to create specific service instances.
  
- ServiceFactory.java: Provides an abstract interface for service creation.

## Decorators

- TennisCourtDecorator.java: Adds additional features to tennis court services.
  
- TrainerDecorator.java: Enhances services by adding trainer support.

## Reservation and Booking

- Reservation.java: Manages the reservation logic, ensuring proper scheduling and availability.

## Main Application

- SportsCenter.java: Acts as the main entry point for initializing and running the sports center.
  
- SportsCenterApp.java: The primary application class, integrating all components and providing the main interface.

## Features

- Flexible booking system for various sports center services.
  
- Decorator pattern for customizing services.
  
- Factory pattern for modular service creation.
  
- User-friendly client management and reservation handling.

## Setup and Usage

- Clone the repository or download the project files.
  
- Ensure you have Java installed (version 8 or higher).

- Navigate to the src directory and compile the project :
`javac *.java`

- Run the main application :
`java SportsCenterApp`
