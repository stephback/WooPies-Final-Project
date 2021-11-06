DROP DATABASE IF EXISTS woopies;
CREATE DATABASE IF NOT EXISTS woopies;
USE woopies;

DROP TABLE IF EXISTS individual_order_status;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS price_per_pie;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS pies;

 -- Dropped is_gluten_free from table due to boolean jdbc result set issue need to research and try again  
CREATE TABLE pies (
    pie_pk int unsigned NOT NULL AUTO_INCREMENT,
    pie_id varchar(45) NOT NULL,
    pie_size enum ('TWO_INCH', 'FOUR_INCH', 'NINE_INCH'),
    pie_type enum ('SAVORY', 'SWEET'),
     PRIMARY KEY (pie_pk),
     UNIQUE KEY (pie_id, pie_size, pie_type)
);
-- Add dateTimeCreated to customers to catch/track a SQL injection/hack
CREATE TABLE customers (
    customer_pk int unsigned NOT NULL AUTO_INCREMENT,
    address_fk int unsigned NOT NULL,
    customer_id varchar(40) NOT NULL,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    phone varchar(20) NOT NULL,
     PRIMARY KEY (customer_pk)
    );
   -- Add dateTimeCreated to address to catch/track a SQL injection/hack
  CREATE TABLE address (
 	address_pk int unsigned NOT NULL AUTO_INCREMENT,
  	customer_fk int unsigned NOT NULL,
 	billing_address varchar(150) NOT NULL,
  	shipping_address varchar(150) NOT NULL,
  	 PRIMARY KEY (address_pk),
  	 FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
  );
-- Add dateTimeCreated to price_per_pie so last price adjustment can be seen
CREATE TABLE price_per_pie (
	price_per_pie_pk int unsigned NOT NULL AUTO_INCREMENT,
    pie_fk int unsigned NOT NULL,
  	price_per_pie decimal(6, 2) NOT NULL,
     PRIMARY KEY (price_per_pie_pk),
     FOREIGN KEY (pie_fk) REFERENCES pies (pie_pk) ON DELETE CASCADE
);

CREATE TABLE order_items (
	order_item_pk int unsigned NOT NULL AUTO_INCREMENT,
    pie_fk int unsigned NOT NULL,
    price_per_pie_fk int unsigned NOT NULL,
    quantity int unsigned NOT NULL,
     PRIMARY KEY (order_item_pk),
     FOREIGN KEY (pie_fk) REFERENCES pies (pie_pk) ON DELETE CASCADE,
     FOREIGN KEY (price_per_pie_fk) REFERENCES price_per_pie (price_per_pie_pk) ON DELETE CASCADE
);
-- Add dateTimeCreated to orders so a date/time stamp is created with each order creation
CREATE TABLE orders (
	order_pk int unsigned NOT NULL AUTO_INCREMENT,
    order_item_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_total decimal(6, 2) NOT NULL,
     PRIMARY KEY (order_pk),
     FOREIGN KEY (order_item_fk) REFERENCES order_items (order_item_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);
-- Called order_status IndividualOrderStatus so I could make enum class called OrderStatus
-- Add dateTimeCreated to order_status so a date/time stamp is created with each order_status creation
CREATE TABLE individual_order_status (
	order_status_pk int unsigned NOT NULL AUTO_INCREMENT,
	order_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_status enum('ORDER RECEIVED','BAKING IN OVEN', 'PACKED', 'SHIPPED'),
    shipping_status enum ('PRE-TRANSIT', 'IN-TRANSIT', 'OUT FOR DELIVERY', 'DELIVERED'),
     PRIMARY KEY (order_status_pk),
     FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);

