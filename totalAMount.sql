DELIMITER //
CREATE TRIGGER total_price
    BEFORE INSERT ON purchased
    FOR EACH ROW
BEGIN
    DECLARE price DOUBLE;
    DECLARE quantity INT;

    SELECT p.price, pq.quantity
    INTO price, quantity
    FROM products p
             JOIN quantity q ON p.code = q.productCode
    WHERE q.id = NEW.q_id;

    -- Calculate the total price
    SET NEW.total = price * quantity;
END //
DELIMITER ;