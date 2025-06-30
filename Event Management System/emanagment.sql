use emanagment;

CREATE TABLE feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    feedback_text TEXT,
    feedback_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    event_time TIME NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    event_city VARCHAR(255) NOT NULL,
    venue_id INT,
    price INT,
    quantity INT NOT NULL
);

CREATE TABLE Event (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    event_time TIME NOT NULL,
    event_capacity INT NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    event_city VARCHAR(255) NOT NULL,
    venue_id INT,
    price INT
);

CREATE TABLE Venue (
    venue_id INT AUTO_INCREMENT PRIMARY KEY,
    venue_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);


-- Inserting 10 values into the feedback table
INSERT INTO feedback (feedback_text) VALUES 
    ('Good event, enjoyed it!'),
    ('Could have been better.'),
    ('Excellent organization.'),
    ('The venue was too crowded.'),
    ('Great experience overall.'),
    ('Loved the entertainment.'),
    ('Disappointed with the food.'),
    ('Amazing atmosphere.'),
    ('Needs improvement in communication.'),
    ('Best event I attended this year.');

-- Inserting 10 values into the Tickets table
INSERT INTO Tickets (event_id, event_name, event_date, event_time, event_type, event_city, venue_id, price, quantity) VALUES 
    (1, 'Event 1', '2024-05-20', '18:00:00', 'Music', 'New York', 1, 50, 2),
    (2, 'Event 2', '2024-06-15', '19:30:00', 'Sports', 'Los Angeles', 2, 40, 1),
    (3, 'Event 3', '2024-07-10', '20:00:00', 'Conference', 'Chicago', 3, 30, 3),
    (4, 'Event 4', '2024-08-05', '17:00:00', 'Exhibition', 'San Francisco', 4, 25, 2),
    (5, 'Event 5', '2024-09-18', '16:30:00', 'Theatre', 'Boston', 5, 60, 4),
    (6, 'Event 6', '2024-10-22', '19:00:00', 'Music', 'Miami', 6, 45, 2),
    (7, 'Event 7', '2024-11-30', '18:30:00', 'Sports', 'Seattle', 7, 35, 3),
    (8, 'Event 8', '2024-12-10', '20:00:00', 'Conference', 'Dallas', 8, 30, 1),
    (9, 'Event 9', '2025-01-05', '17:30:00', 'Exhibition', 'Denver', 9, 20, 2),
    (10, 'Event 10', '2025-02-14', '19:45:00', 'Theatre', 'Houston', 10, 55, 3);

-- Inserting 10 values into the Event table
INSERT INTO Event (event_name, event_date, event_time, event_capacity, event_type, event_city, venue_id, price) VALUES 
    ('Event 1', '2024-05-20', '18:00:00', 200, 'Music', 'New York', 1, 50),
    ('Event 2', '2024-06-15', '19:30:00', 150, 'Sports', 'Los Angeles', 2, 40),
    ('Event 3', '2024-07-10', '20:00:00', 300, 'Conference', 'Chicago', 3, 30),
    ('Event 4', '2024-08-05', '17:00:00', 250, 'Exhibition', 'San Francisco', 4, 25),
    ('Event 5', '2024-09-18', '16:30:00', 180, 'Theatre', 'Boston', 5, 60),
    ('Event 6', '2024-10-22', '19:00:00', 220, 'Music', 'Miami', 6, 45),
    ('Event 7', '2024-11-30', '18:30:00', 170, 'Sports', 'Seattle', 7, 35),
    ('Event 8', '2024-12-10', '20:00:00', 300, 'Conference', 'Dallas', 8, 30),
    ('Event 9', '2025-01-05', '17:30:00', 250, 'Exhibition', 'Denver', 9, 20),
    ('Event 10', '2025-02-14', '19:45:00', 200, 'Theatre', 'Houston', 10, 55);

-- Inserting 10 values into the Venue table
INSERT INTO Venue (venue_name, location, capacity) VALUES 
    ('Venue 1', 'New York', 300),
    ('Venue 2', 'Los Angeles', 250),
    ('Venue 3', 'Chicago', 400),
    ('Venue 4', 'San Francisco', 350),
    ('Venue 5', 'Boston', 280),
    ('Venue 6', 'Miami', 320),
    ('Venue 7', 'Seattle', 270),
    ('Venue 8', 'Dallas', 400),
    ('Venue 9', 'Denver', 350),
    ('Venue 10', 'Houston', 300);

select * from feedback;
select * from Event;
select * from Venue;
select * from Tickets;
