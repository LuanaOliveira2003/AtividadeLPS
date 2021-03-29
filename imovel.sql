-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29-Mar-2021 às 17:06
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `imovel`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cliente`
--

CREATE TABLE `tbl_cliente` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_cliente`
--

INSERT INTO `tbl_cliente` (`id_cliente`, `nome`, `cpf`, `endereco`, `idade`) VALUES
(1, 'carlos', '099.938.626-30', 'guarapari', 55);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_comissao`
--

CREATE TABLE `tbl_comissao` (
  `id_comissao` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_comissao`
--

INSERT INTO `tbl_comissao` (`id_comissao`, `nome`, `valor`) VALUES
(3, 'gabriel', 1234);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_corretor`
--

CREATE TABLE `tbl_corretor` (
  `id_corretor` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `idade` int(11) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_corretor`
--

INSERT INTO `tbl_corretor` (`id_corretor`, `nome`, `cpf`, `endereco`, `idade`, `salario`) VALUES
(3, 'pedro', '099.938.252-41', 'pra?a bias fortes', 14, 2500);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_imovel`
--

CREATE TABLE `tbl_imovel` (
  `id_imovel` int(11) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `cep` varchar(40) NOT NULL,
  `rua` varchar(20) NOT NULL,
  `bairro` varchar(40) NOT NULL,
  `numero` int(11) NOT NULL,
  `referencia` varchar(40) NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbl_imovel`
--

INSERT INTO `tbl_imovel` (`id_imovel`, `cidade`, `estado`, `cep`, `rua`, `bairro`, `numero`, `referencia`, `valor`) VALUES
(3, 'Merces', 'MG', '36190000', 'Carangola', 'Carangola', 143, 'Perto do Hospital', 300000);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `tbl_comissao`
--
ALTER TABLE `tbl_comissao`
  ADD PRIMARY KEY (`id_comissao`);

--
-- Índices para tabela `tbl_corretor`
--
ALTER TABLE `tbl_corretor`
  ADD PRIMARY KEY (`id_corretor`);

--
-- Índices para tabela `tbl_imovel`
--
ALTER TABLE `tbl_imovel`
  ADD PRIMARY KEY (`id_imovel`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbl_comissao`
--
ALTER TABLE `tbl_comissao`
  MODIFY `id_comissao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_corretor`
--
ALTER TABLE `tbl_corretor`
  MODIFY `id_corretor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_imovel`
--
ALTER TABLE `tbl_imovel`
  MODIFY `id_imovel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
