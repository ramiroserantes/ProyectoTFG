DROP TABLE IF EXISTS Reply;
DROP TABLE IF EXISTS Topic;
DROP TABLE IF EXISTS TopicCategory;

DROP TABLE IF EXISTS Purchase;
DROP TABLE IF EXISTS ShoppingCartItem;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS ShoppingCart;

DROP TABLE IF EXISTS TransactionTable;
DROP TABLE IF EXISTS OrderTable;

DROP TABLE IF EXISTS Stats;
DROP TABLE IF EXISTS User;

/**************************************************************************************/

/********************************** Users *********************************************/

CREATE TABLE User (

    id BIGINT NOT NULL AUTO_INCREMENT,
    userName varchar(60) NOT NULL,
    passWord varchar(60) NOT NULL,
    email varchar(60) NOT NULL,
    webRole int NOT NULL DEFAULT 0,
    coins BIGINT NOT NULL,
    premiumCoins BIGINT NOT NULL DEFAULT 0,
    donatedMoney DECIMAL(7, 2) NOT NULL DEFAULT 0.0,
    registeredDate DATETIME NOT NULL,
    lastTimeOnline DATETIME NOT NULL,
    reputation int NOT NULL,
    vipRole int NOT NULL,
    ranking BIGINT NOT NULL,

    CONSTRAINT UserPK PRIMARY KEY (id),
    CONSTRAINT UserNameUniqueKey UNIQUE (userName)

) ENGINE = InnoDB;

CREATE INDEX UserIndexByUserName ON User (userName);

CREATE TABLE Stats (

    statName VARCHAR(60) NOT NULL,
    statValue DECIMAL(11,2) NOT NULL,

    userId BIGINT NOT NULL,

    PRIMARY KEY (statName, userId),
    CONSTRAINT UserFK FOREIGN KEY (userId)
        REFERENCES User(id)

) ENGINE = InnoDB;

/********************************** Auctions ******************************************/

CREATE TABLE OrderTable (

    id BIGINT NOT NULL AUTO_INCREMENT,
    creationDate DATETIME NOT NULL,
    expirationDate DATETIME NOT NULL,
    requiredAmount int NOT NULL,
    adquiredAmount int NOT NULL,
    pricePerUnit int NOT NULL,
    status int NOT NULL,
    orderType TINYINT NOT NULL,

    userId BIGINT NOT NULL,

    CONSTRAINT OrderTablePK PRIMARY KEY (id),
    CONSTRAINT userIdFK FOREIGN KEY (userId)
        REFERENCES User(id)

) ENGINE = InnoDB;

CREATE TABLE TransactionTable (

    dateOfTransaction DATETIME NOT NULL,
    transactionValue int NOT NULL,
    transactedAmount int NOT NULL,

    orderId BIGINT NOT NULL,

    PRIMARY KEY (dateOfTransaction, orderId),
    CONSTRAINT orderTableFK FOREIGN KEY (orderId)
        REFERENCES OrderTable(id)

) ENGINE = InnoDB;

/********************************** Shop ******************************************/

CREATE TABLE Category (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    CONSTRAINT CategoryPK PRIMARY KEY (id),
    CONSTRAINT CategoryNameUniqueKey UNIQUE (name)

) ENGINE = InnoDB;

CREATE TABLE ShoppingCart (

    id BIGINT NOT NULL AUTO_INCREMENT,
    userId BIGINT NOT NULL,

    CONSTRAINT ShoppingCartPK PRIMARY KEY (id),
    CONSTRAINT ShoppingCartFK FOREIGN KEY (userId)
        REFERENCES User(id)

) ENGINE = InnoDB;

CREATE TABLE Product (

    id BIGINT NOT NULL AUTO_INCREMENT,
    isQuantityLimited TINYINT NOT NULL,
    gameValue BIGINT NULL,
    realValue DECIMAL(11, 2) NULL,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(60) NOT NULL,
    discount DECIMAL(3, 2) NULL,

    categoryId BIGINT NOT NULL,

    CONSTRAINT ProductPK PRIMARY KEY (id),
    CONSTRAINT CategoryFK FOREIGN KEY (categoryId)
        REFERENCES Category(id)
) ENGINE = InnoDB;

CREATE TABLE ShoppingCartItem (

    id BIGINT NOT NULL AUTO_INCREMENT,
    quantity int NOT NULL,

    shoppingCartId BIGINT NOT NULL,
    productId BIGINT NOT NULL,

    CONSTRAINT ShoppingCartItemPK PRIMARY KEY (id),
    CONSTRAINT ShoppingCartItemFK FOREIGN KEY (shoppingCartId)
        REFERENCES ShoppingCart(id),
    CONSTRAINT ProductFK FOREIGN KEY (productId)
        REFERENCES Product(id)

) ENGINE = InnoDB;

CREATE TABLE Purchase (

    id BIGINT NOT NULL AUTO_INCREMENT,
    premiumCoinValue BIGINT NULL,
    realValue DECIMAL(11, 2) NULL,
    purchaseDate DATETIME NOT NULL,
    quantity int NOT NULL,

    productId BIGINT NOT NULL,
    userId BIGINT NOT NULL,

    CONSTRAINT PurchasePK PRIMARY KEY (id),
    CONSTRAINT PurchaseProductFK FOREIGN KEY (productId)
        REFERENCES Product(id),
    CONSTRAINT PurchaseUserFK FOREIGN KEY (userId)
        REFERENCES User(id)

) ENGINE = InnoDB;

/********************************** Forum ******************************************/

CREATE TABLE TopicCategory (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    CONSTRAINT TopicCategoryPK PRIMARY KEY (id),
    CONSTRAINT TopicCategoryUniqueKey UNIQUE (name)

) ENGINE = InnoDB;

CREATE TABLE Topic (

    id BIGINT NOT NULL AUTO_INCREMENT,
    postedDate DATETIME NOT NULL,
    header VARCHAR(300) NOT NULL,
    content VARCHAR(1200) NOT NULL,
    views int NOT NULL,

    topicCategoryId BIGINT NOT NULL,
    userId BIGINT NOT NULL,

    CONSTRAINT TopicPK PRIMARY KEY (id),
    CONSTRAINT TopicCategoryFK FOREIGN KEY (topicCategoryId)
        REFERENCES TopicCategory(id),
    CONSTRAINT TopicUserFK FOREIGN KEY (id)
        REFERENCES User(id)

) ENGINE = InnoDB;

CREATE TABLE Reply (

    id BIGINT NOT NULL AUTO_INCREMENT,
    content VARCHAR (1200) NOT NULL,
    isEdited TINYINT NOT NULL,
    postedDate DATETIME NOT NULL,
    editedDate DATETIME NOT NULL,

    userId BIGINT NOT NULL,
    topicId BIGINT NOT NULL,

    CONSTRAINT ReplyPK PRIMARY KEY (id),
    CONSTRAINT ReplyUserFK FOREIGN KEY (userId)
        REFERENCES User(id),
    CONSTRAINT ReplyTopicFK FOREIGN KEY (topicId)
        REFERENCES Topic(id)

) ENGINE = InnoDB;

