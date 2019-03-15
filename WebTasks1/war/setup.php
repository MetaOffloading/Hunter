<?php
require 'db.php';

$db = mysqli_connect($host, $user, $password);

// Create database
$sql = "CREATE DATABASE hunter";
if (mysqli_query($db, $sql) === TRUE) {
    echo "Database created successfully";
} else {
    echo "Error creating database: " . $conn->error;
}

echo "<br>";

mysqli_close($db);

$db = mysqli_connect($host, $user, $password, $database);

if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
} else {
    printf("Successful connection.\n");
}

echo "<br>";

$sql = "
CREATE TABLE `data` (
  `dataType` varchar(128) DEFAULT '0',
  `participantCode` varchar(128) DEFAULT NULL,
  `experimentCode` varchar(128) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `sessionKey` varchar(255) DEFAULT NULL,
  `data` text,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
";

if (mysqli_query($db, $sql) === TRUE) {
    printf("Table 1 created successfully\n");
} else {
    printf("error with table 1: %s\n", mysqli_error($db));
}

echo "<br>";

$sql = "
CREATE TABLE `status` (
  `participantCode` varchar(128) DEFAULT NULL,
  `experimentCode` varchar(128) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `status` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
";

if (mysqli_query($db, $sql) === TRUE) {
    printf("Table 2 created successfully\n");
} else {
    printf("error with table preTrial: %s\n", mysqli_error($db));
}

mysqli_close($db);
?>