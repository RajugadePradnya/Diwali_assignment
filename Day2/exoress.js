const express = require("express");
const mysql = require("mysql2");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(bodyParser.json());

// MySQL connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root123",     
  password: "s232310",       
  database: "userdb"
});

db.connect(err => {
  if (err) {
    console.error("Database connection failed:", err);
  } else {
    console.log("Connected to MySQL database.");
  }
});

// POST route for registration
app.post("/register", (req, res) => {
  const { first_name, last_name, email, userid, password } = req.body;

  if (!first_name || !last_name || !email || !userid || !password) {
    return res.status(400).json({ message: "All fields are required" });
  }

  const query = `INSERT INTO Users (first_name, last_name, email, userid, password)
                 VALUES (?, ?, ?, ?, ?)`;

  db.query(query, [first_name, last_name, email, userid, password], (err, result) => {
    if (err) {
      console.error("Error inserting data:", err);
      res.status(500).json({ message: "Error saving user" });
    } else {
      res.status(201).json({ message: "User registered successfully!" });
    }
  });
});

app.listen(5000, () => console.log("Server running on port 5000"));
