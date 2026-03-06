-- 1. Veritabanýný Oluþtur
CREATE DATABASE PoliceMDC;
GO

USE PoliceMDC;
GO

-- 2. Kullanýcýlar Tablosu (mdcadduser.java sýnýfý için)
CREATE TABLE Kullanicilar (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL UNIQUE,
    Password NVARCHAR(50) NOT NULL,
    Rank NVARCHAR(50),
    AddedBy NVARCHAR(50) -- Moderatör
);

-- 3. Þüpheliler Tablosu (mdc.java case 1 için)
CREATE TABLE Supheliler (
    TC NVARCHAR(11) PRIMARY KEY,
    AdSoyad NVARCHAR(100),
    SucKaydi NVARCHAR(MAX),
    AranmaDurumu BIT -- 1: Aranýyor, 0: Temiz
);

-- 4. Araçlar Tablosu (mdcGUI.java plakaSorgu için)
CREATE TABLE Araclar (
    Plaka NVARCHAR(20) PRIMARY KEY,
    MarkaModel NVARCHAR(100),
    Sahibi NVARCHAR(100),
    Durum NVARCHAR(50)
);

-- 5. Raporlar Tablosu (mdcrapor.java sýnýfý için)
CREATE TABLE Raporlar (
    RaporID INT PRIMARY KEY IDENTITY(1,1),
    OlayOzeti NVARCHAR(MAX),
    Lokasyon NVARCHAR(100),
    RaporuYazan NVARCHAR(100),
    Tarih DATETIME DEFAULT GETDATE()
);

-- TEST VERÝSÝ EKLEME (Giriþ yapabilmen için)
INSERT INTO Kullanicilar (Username, Password, Rank, AddedBy) 
VALUES ('Murat', '123mrt123', 'Amir', 'Sistem');

INSERT INTO Supheliler (TC, AdSoyad, SucKaydi, AranmaDurumu)
VALUES ('12345678901', 'Ahmet Yýlmaz', 'Hýrsýzlýk (2022)', 1);