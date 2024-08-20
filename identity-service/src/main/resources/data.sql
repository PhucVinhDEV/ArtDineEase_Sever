
ALTER TABLE category_of_food_store
    MODIFY COLUMN is_deleted TINYINT(1) DEFAULT 0;

ALTER TABLE catagory_of_product
    MODIFY COLUMN is_deleted TINYINT(1) DEFAULT 0;

INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (1, 'Fast Food', 'Category for fast food restaurants', 'admin', NOW(), 'admin', NOW());

INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (2, 'Fine Dining', 'Category for fine dining restaurants', 'admin', NOW(), 'admin', NOW());

INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (3, 'Cafe', 'Category for cafes', 'admin', NOW(), 'admin', NOW());


INSERT INTO catagory_of_product (name, description, created_date, created_by, is_deleted) VALUES
    ('Khai vị & Món ăn nhẹ (Appetizers & Snacks)', 'Bao gồm các món khai vị và món ăn nhẹ.', NOW(), 'adnmin', 0),
    ('Món chính (Main Courses)', 'Bao gồm tất cả các món chính như thịt, cá, mì, cơm, v.v.', NOW(), 'adnmin', 0),
    ('Món ăn kèm & Món chay (Side Dishes & Vegetarian)', 'Bao gồm các món ăn kèm và món ăn chay.', NOW(), 'adnmin', 0),
    ('Món tráng miệng (Desserts)', 'Bao gồm các loại món tráng miệng.', NOW(), 'adnmin', 0),
    ('Thức uống (Beverages)', 'Bao gồm tất cả các loại đồ uống.', NOW(), 'adnmin', 0),
    ('Món đặc sản (Specialty Dishes)', 'Bao gồm các món đặc biệt hoặc món ăn theo mùa.', NOW(), 'adnmin', 0),
    ('Món ăn truyền thống (Traditional Dishes)', 'Bao gồm các món ăn truyền thống của Việt Nam, thường xuất hiện trong các dịp lễ tết hoặc bữa ăn gia đình.', NOW(), 'adnmin', 0),
    ('Món nước (Vietnamese Noodle Soups)', 'Bao gồm các loại món nước đặc trưng của Việt Nam.', NOW(), 'adnmin', 0),
    ('Món nướng & Lẩu (Grilled & Hotpot Dishes)', 'Bao gồm các món nướng và lẩu, phổ biến trong các buổi tiệc, họp mặt gia đình và bạn bè.', NOW(), 'adnmin', 0),
    ('Món cuốn (Vietnamese Rolls)', 'Bao gồm các loại món cuốn truyền thống của Việt Nam.', NOW(), 'adnmin', 0),
    ('Món ăn vặt (Vietnamese Street Food)', 'Bao gồm các món ăn vặt, ăn nhẹ, phổ biến trên các đường phố Việt Nam.', NOW(), 'adnmin', 0);





INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (1, 'Fast Food', 'Category for fast food restaurants', 'admin', NOW(), 'admin', NOW());

INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (2, 'Fine Dining', 'Category for fine dining restaurants', 'admin', NOW(), 'admin', NOW());

INSERT INTO category_of_food_store (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES (3, 'Cafe', 'Category for cafes', 'admin', NOW(), 'admin', NOW());


INSERT INTO topic (name, created_by, created_date, last_modified_by, last_modified_date, is_deleted) VALUES
            ('Ẩm thực truyền thống (Traditional Cuisine)', 'admin', NOW(), 'admin', NOW(), 0),
            ('Ẩm thực đường phố (Street Food)', 'admin', NOW(), 'admin', NOW(), 0),
            ('Ẩm thực chay (Vegetarian Cuisine)', 'admin', NOW(), 'admin', NOW(), 0),
            ('Ẩm thực hiện đại (Modern Cuisine)', 'admin', NOW(), 'admin', NOW(), 0),
            ('Cửa hàng nổi tiếng (Famous Restaurants)', 'admin', NOW(), 'admin', NOW(), 0);

INSERT INTO size (name, description, created_by, created_date, last_modified_by, last_modified_date, is_deleted) VALUES
            ('Small', 'Kích thước nhỏ, phù hợp với các sản phẩm nhỏ gọn hoặc khẩu phần nhỏ.', 'admin', NOW(), 'admin', NOW(), 0),
            ('Medium', 'Kích thước trung bình, thường là lựa chọn phổ biến cho nhiều loại sản phẩm.', 'admin', NOW(), 'admin', NOW(), 0),
            ('Large', 'Kích thước lớn, phù hợp với các sản phẩm có khẩu phần lớn hoặc dành cho nhiều người.', 'admin', NOW(), 'admin', NOW(), 0),
            ('Extra Large', 'Kích thước cực lớn, thường dùng cho các sản phẩm đặc biệt lớn hoặc cho nhóm lớn người dùng.', 'admin',  NOW(), 'admin',NOW(), 0);

select * from product_size;