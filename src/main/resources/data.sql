CREATE TABLE IF NOT EXISTS prices (
     brand_id INT,
     start_date DATETIME,
     end_date DATETIME,
     price_list INT,
     product_id INT,
     priority INT,
     price DECIMAL(10, 2),
    currency VARCHAR(3),
    last_update DATETIME,
    last_update_by VARCHAR(50)
    );

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, currency, last_update, last_update_by)
VALUES
(1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR', '2020-03-26 14:49:07', 'user1'),
(1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR', '2020-05-26 15:38:22', 'user1'),
(1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR', '2020-05-26 15:39:22', 'user2'),
(1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR', '2020-06-02 10:14:00', 'user1');
