Create table TB_TEMA
( COD_TEMA   varchar(10)  not null,
  NOMBRE     varchar(30)  not null,
     constraint PK_TB_TEMA
     primary key (COD_TEMA));

Create table TB_CLASIFICACION
( COD_CLASI   varchar(10)  not null,
  NOMBRE     varchar(30)  not null,
     constraint PK_TB_CLASIFICACION
     primary key (COD_CLASI));

Create table TB_PAIS
( COD_PAIS   INT  not null,
  NOMBRE     varchar(30)  not null,
     constraint PK_TB_PAIS
     primary key (COD_PAIS));

Create table TB_EDITORIAL
( ID_EDITORIAL   varchar(10)  not null,
  NOMBRE     varchar(30)  not null,
  TELEFONO	INT,
  DIRECCION varchar(200),
  COD_PAIS   INT  not null,
  CIUDAD     varchar(30),
     constraint PK_TB_EDITORIAL
     primary key (ID_EDITORIAL),
	 constraint FK_TB_PAIS_TB_EDITORIAL
	 foreign key (COD_PAIS)
     references TB_PAIS(COD_PAIS));

Create table TB_AUTOR
( ID_AUTOR   varchar(10)  not null,
  NOMBRE     varchar(30)  not null,
  APELLIDO     varchar(30)  not null,
  COD_PAIS   INT  not null,
  AÑO_NACI	 DECIMAL(4),
  OBSERVACION     TEXT,
     constraint PK_TB_AUTOR
     primary key (ID_AUTOR),
	 constraint FK_TB_PAIS_TB_AUTOR
	 foreign key (COD_PAIS)
     references TB_PAIS(COD_PAIS));

Create table TB_STOCK
( COD_STOCK   INT  not null,
  CATIDAD_ALMACENADA INT not null,
  UNIDADES_COMPRADAS INT not null,
  UNIDADES_VENDIDAS INT,
     constraint PK_TB_STOCK
     primary key (COD_STOCK));

Create table TB_LIBRO
( ISBN   varchar(30)  not null,
  TITULO     varchar(60)  not null,
  SUBTITULO     varchar(60),
  DESCRIPCION	TEXT,
  AÑO_EMICION	 DECIMAL(4) not null,
  NUMERO_PAG     INT not null,
  NUMERO_EDICION     INT,
  TIPO_CARATURA     varchar(7) not null,
  NUMERO_ESTANTERIA     INT,
  COD_STOCK   INT  not null,
  COSTO     INT not null,
  PRECIO     INT not null,
  COD_CLASI   varchar(10)  not null,
  ID_EDITORIAL   varchar(10)  not null,
     constraint PK_TB_LIBRO
     primary key (ISBN),
	 constraint FK_TB_CLASIFICACION_TB_LIBRO
	 foreign key (COD_CLASI)
     references TB_CLASIFICACION(COD_CLASI),
	 constraint FK_TB_EDITORIAL_TB_LIBRO
	 foreign key (ID_EDITORIAL)
     references TB_EDITORIAL(ID_EDITORIAL));

Create table TB_TEMA_LIBRO
( ISBN   varchar(30)  not null,
  COD_TEMA   varchar(10)  not null,
     constraint PK_TEMA_LIBRO
     primary key (ISBN,COD_TEMA),
	 constraint FK_TB_TEMA_TB_TEMA_LIBRO
	 foreign key (COD_TEMA)
     references TB_TEMA(COD_TEMA),
	 constraint FK_TB_LIBRO_TB_TEMA_LIBRO
	 foreign key (ISBN)
     references TB_LIBRO(ISBN));

Create table TB_AUTOR_LIBRO
( ISBN   varchar(30)  not null,
  ID_AUTOR   varchar(10)  not null,
     constraint PK_AUTOR_LIBRO
     primary key (ISBN,ID_AUTOR),
	 constraint FK_TB_AUTOR_TB_AUTOR_LIBRO
	 foreign key (ID_AUTOR)
     references TB_AUTOR(ID_AUTOR),
	 constraint FK_TB_LIBRO_TB_AUTOR_LIBRO
	 foreign key (ISBN)
     references TB_LIBRO(ISBN));

Create table TB_CLIENTE
( CEDULA   varchar(16)  not null,
  NOMBRE     varchar(30)  not null,
  APELLIDO1     varchar(30)  not null,
  APELLIDO2     varchar(30)  not null,
  TELEFONO	INT,
     constraint PK_TB_CLIENTE
     primary key (CEDULA));

Create table TB_HACIENTO_CONTABLE
( COD_HACIENTO	INT  not null,
  FECHA     DATE  not null,
  TOTAL_BRUTO	DECIMAL,
  COSTOS_TOTALES	DECIMAL,
  TOTAL_GANANCIA	DECIMAL,
     constraint PK_HACIENTO_CONTABLE
     primary key (COD_HACIENTO));

Create table TB_ENCABEZADO
( COD_FACTURA	INT  not null,
  FECHA     DATE  not null,
  SUBTOTAL	INT not null,
  IMPUESTO_VENTAS	INT not null,
  TOTAL	INT not null,
  CEDULA   varchar(16)  not null,
  COD_HACIENTO	INT  not null,
     constraint PK_TB_ENCABEZADO
     primary key (COD_FACTURA),
	 constraint FK_TB_CLIENTE_TB_ENCABEZADO
	 foreign key (CEDULA)
     references TB_CLIENTE(CEDULA),
	 constraint FK_TB_HACIENTO_CONTABLE_TB_ENCABEZADO
	 foreign key (COD_HACIENTO)
     references TB_HACIENTO_CONTABLE(COD_HACIENTO));

Create table TB_DETALLE
( COD_FACTURA	INT  not null,
  ISBN   varchar(30)  not null,
  UNIDADES	INT not null,
  COSTO_UNITARIO	INT not null,
  TOTAL	INT not null,
     constraint PK_TB_DETALLE
     primary key (COD_FACTURA,ISBN),
	 constraint FK_TB_ENCABEZADO_TB_DETALLE
	 foreign key (COD_FACTURA)
     references TB_ENCABEZADO(COD_FACTURA),
	 constraint FK_TB_LIBROE_TB_DETALLE
	 foreign key (ISBN)
     references TB_LIBRO(ISBN));
	 
	 

Insert into TB_CLASIFICACION
Values ('Beh','Behavioral Science'); 

Insert into TB_CLASIFICACION
Values ('Bus','Business and Economics'); 

Insert into TB_CLASIFICACION
Values ('Che','Chemistry'); 

Insert into TB_CLASIFICACION
Values ('Phy','Physics and Astronomy'); 





Insert into TB_TEMA
Values ('His','History of Science
'); 
Insert into TB_TEMA
Values ('Acc','Accounting
'); 
Insert into TB_TEMA
Values ('Aer','Aerospace Technology
'); 
Insert into TB_TEMA
Values ('Ana','Analytical Chemistry
'); 
Insert into TB_TEMA
Values ('Ban','Banking
'); 
Insert into TB_TEMA
Values ('Bio','Biomaterials
'); 
Insert into TB_TEMA
Values ('Biom','Biomedical Engineering
'); 
Insert into TB_TEMA
Values ('Bioo','Bioorganic Chemistry
'); 
Insert into TB_TEMA
Values ('Biop','Biophysics
'); 
Insert into TB_TEMA
Values ('Cer','Ceramics
'); 
Insert into TB_TEMA
Values ('Cha','Characterization
'); 
Insert into TB_TEMA
Values ('Cla','Classical and Quantum
'); 
Insert into TB_TEMA
Values ('Cli','Clinical
'); 
Insert into TB_TEMA
Values ('Con','Condensed Matter Physics
'); 
Insert into TB_TEMA
Values ('Dat','Database Management
'); 
Insert into TB_TEMA
Values ('Dev','Developmental Psychology
'); 
Insert into TB_TEMA
Values ('Eco','Economics general
'); 
Insert into TB_TEMA
Values ('Ene','Energy Technology
'); 
Insert into TB_TEMA
Values ('Eur','European Law
'); 
Insert into TB_TEMA
Values ('Ext','Extraterrestrial Physics
'); 
Insert into TB_TEMA
Values ('Ind','Industrial
'); 
Insert into TB_TEMA
Values ('Inf','Information Systems
'); 
Insert into TB_TEMA
Values ('Lea','Leadership
'); 
Insert into TB_TEMA
Values ('Ope','Operation Research
'); 
Insert into TB_TEMA
Values ('Opt','Optics
'); 
Insert into TB_TEMA
 Values ('Org','Organic Chemistry
'); 
Insert into TB_TEMA
Values ('Pro','Production
'); 
Insert into TB_TEMA
Values ('Psy','Psychiatry
'); 
Insert into TB_TEMA
Values ('Psyc','Psychology
'); 
Insert into TB_TEMA
Values ('Qua','Quality Control
'); 
Insert into TB_TEMA
Values ('Quan','Quantum Information Technology'); 
Insert into TB_TEMA
Values ('Quant','Quantum Physics
'); 
Insert into TB_TEMA
Values ('Soc','Sociology
'); 
Insert into TB_TEMA
Values ('Spe','Spectroscopy
'); 
Insert into TB_TEMA
Values ('Str','Structural Materials
'); 
Insert into TB_TEMA
Values ('Tec','Technology Policy
'); 
Insert into TB_TEMA
Values ('The','Thermodynamics
'); 






Insert into TB_PAIS 
Values (1,'Costa Rica
')
Insert into TB_PAIS 
Values (2,'España
')
Insert into TB_PAIS 
Values (3,'Estados Unidos
')
Insert into TB_PAIS 
Values (4,'Bulgaria
')
Insert into TB_PAIS 
Values (5,'Chipre
')
Insert into TB_PAIS 
Values (6,'Dinamarca
')
Insert into TB_PAIS 
Values (7,'Finlandia
')
Insert into TB_PAIS 
Values (8,'Francia
')
Insert into TB_PAIS 
Values (9,'Grecia
')
Insert into TB_PAIS 
Values (10,'Hungria
')
Insert into TB_PAIS 
Values (11,'Irlanda
')
Insert into TB_PAIS 
Values (12,'Italia
')
Insert into TB_PAIS 
Values (13,'Luxemburgo
')
Insert into TB_PAIS 
Values (14,'Malta
')
Insert into TB_PAIS 
Values (15,'Paises Bajes
')
Insert into TB_PAIS 
Values (16,'Polonia
')
Insert into TB_PAIS 
Values (17,'Portugal
')
Insert into TB_PAIS 
Values (18,'Reino Unido
')
Insert into TB_PAIS 
Values (19,'Alemania
')
Insert into TB_PAIS 
Values (20,'Rumania
')
Insert into TB_PAIS 
Values (21,'Argentina
')
Insert into TB_PAIS 
Values (22,'Bolivia
')
Insert into TB_PAIS 
Values (23,'Bahamas
')
Insert into TB_PAIS 
Values (24,'Barbados
')
Insert into TB_PAIS 
Values (25,'Belice
')
Insert into TB_PAIS 
Values (26,'Cuba
')
Insert into TB_PAIS 
Values (27,'Dominica
')
Insert into TB_PAIS 
Values (28,'El Salvador
')
Insert into TB_PAIS 
Values (29,'Guatemala
')
Insert into TB_PAIS 
Values (30,'Haití
')
Insert into TB_PAIS 
Values (31,'Honduras
')
Insert into TB_PAIS 
Values (32,'Jamaica
')
Insert into TB_PAIS 
Values (33,'Nicaragua
')
Insert into TB_PAIS 
Values (34,'Panamá
')
Insert into TB_PAIS 
Values (35,'Puerto Rico
')
Insert into TB_PAIS 
Values (36,'República Dominicana
')






Insert into TB_EDITORIAL
Values ('Apl','Aplapac',88582548,'3200 Providence Dr',23,'Nassau
'); 
Insert into TB_EDITORIAL
Values ('Bea','Beascopa',60993024,'2105 E South Blvd',24,'Bridgetown
'); 
Insert into TB_EDITORIAL
Values ('Col','Collins',88875371,'1720 University Blvd',25,'Belmopan
'); 
Insert into TB_EDITORIAL
Values ('Con','Conecta',89180707,'1515 6th Ave S',26,'La Habana
'); 
Insert into TB_EDITORIAL
Values ('Deb','Debate',88408262,'809 University Blvd E',27,'Roseau
'); 
Insert into TB_EDITORIAL
Values ('Grijalbo','Grijalbo',88300211,'101 Sivley Rd SW',28,'San Salvador
'); 
Insert into TB_EDITORIAL
Values ('Pat','Patagonia Media',88801954,'5600 Girby Rd',29,'Ciudad de Guatemala
'); 
Insert into TB_EDITORIAL
Values ('Tem','Tempus',83471547,'3 Mobile Infirmary Cir',30,'Puerto Príncipe
'); 
Insert into TB_EDITORIAL
Values ('Uni','Universitaria',83562349,'701 Princeton Ave SW',31,'Tegucigalpa
'); 
Insert into TB_EDITORIAL
Values ('Com','Comunicaciones',89935757,'6801 Airport Blvd',32,'Kingston
'); 
Insert into TB_EDITORIAL
Values ('Wil','Wiley',88288088,'810 Saint Vincents Dr',33,'Managua
'); 
Insert into TB_EDITORIAL
Values ('Pub','Publicaciones SAGE',88112097,'50 Medical Park Dr E',34,'Ciudad de Panamá
'); 
Insert into TB_EDITORIAL
Values ('Edi','J & J Editorial',87650138,'1600 7th Ave S',35,'San Juan
'); 
Insert into TB_EDITORIAL
Values ('Comp','Compuscript Ltd',25525371,'800 Montclair Rd',36,'Santo Domingo
'); 





Insert into TB_AUTOR 
Values ('Chr','Christopher','Ferguson',1,1950,'COLEGIO MAYOR DE NUESTRA SEÑORA DEL ROSARIO
')
Insert into TB_AUTOR 
Values ('Mic','Michael','Leiter',2,1951,'UNIVERSIDAD DE LA SABANA
')
Insert into TB_AUTOR 
Values ('Stu','Stuart','Carr',3,1952,'UNIVERSIDAD EAFIT
')
Insert into TB_AUTOR 
Values ('Sil','Silvia','Bonino',4,1953,'UNIVERSIDAD DE ANTIOQUIA
')
Insert into TB_AUTOR 
Values ('Tat','Tatyana','Glezerman',5,1954,'PONTIFICIA UNIVERSIDAD JAVERIANA
')
Insert into TB_AUTOR 
Values ('Sab','Sabine','Bährer-Kohler',6,1955,'UNIVERSIDAD CES
')
Insert into TB_AUTOR 
Values ('Liz','Liza','Gold',7,1956,'UNIVERSIDAD ICESI
')
Insert into TB_AUTOR 
Values ('Luc','Luciano ','LAbate',8,1957,'UNIVERSIDAD INDUSTRIAL DE SANTANDER
')
Insert into TB_AUTOR 
Values ('Bin','Bing ','Xu',9,1958,'UNIVERSIDAD DEL NORTE
')
Insert into TB_AUTOR 
Values ('Has','Hasso','Plattner',10,1959,'COLEGIO DE ESTUDIOS SUPERIORES DE ADMINISTRACION-CESA-
')
Insert into TB_AUTOR 
Values ('Ari','Aristide','van Aartsengel',11,1960,'UNIVERSIDAD DEL VALLE
')
Insert into TB_AUTOR 
Values ('Vol','Volker','Windeck',12,1961,'ESCUELA DE INGENIERIA DE ANTIOQUIA
')
Insert into TB_AUTOR 
Values ('Cor','Corinna','Lindow',13,1962,'UNIVERSIDAD EXTERNADO DE COLOMBIA
')
Insert into TB_AUTOR 
Values ('Dan','Daniela','Mancini',14,1963,'UNIVERSIDAD DE CALDAS
')
Insert into TB_AUTOR 
Values ('Sat','Satish','Ukkusuri',15,1964,'UNIVERSIDAD MILITAR-NUEVA GRANADA
')
Insert into TB_AUTOR 
Values ('Luca','Luca','Di Gaspero',16,1965,'UNIVERSIDAD PONTIFICIA BOLIVARIANA
')
Insert into TB_AUTOR 
Values ('Koe','Koen','Dam',17,1966,'UNIVERSIDAD DEL CAUCA
')
Insert into TB_AUTOR 
Values ('Isa','Isabelle','Richelle',18,1967,'UNIVERSIDAD PEDAGOGICA NACIONAL
')
Insert into TB_AUTOR 
Values ('Wei','Wei','Wei',19,1968,'UNIVERSIDAD DE NARIÑO
')
Insert into TB_AUTOR 
Values ('Aje','Ajey','Lele',20,1969,'UNIVERSIDAD DISTRITAL-FRANCISCO JOSE DE CALDAS
')
Insert into TB_AUTOR 
Values ('Chri','Christian','Hertrich',21,1970,'UNIVERSIDAD AUTONOMA DE BUCARAMANGA-UNAB-
')
Insert into TB_AUTOR 
Values ('Phi','Philipp','Gubler',22,1971,'UNIVERSIDAD DEL CAUCA
')







Insert into TB_STOCK Values (1001,36,36,0);

Insert into TB_STOCK Values (1002,12,13,1);

Insert into TB_STOCK Values (1003,8,9,1);

Insert into TB_STOCK Values (1004,9,9,0);

Insert into TB_STOCK Values (1005,7,8,1);

Insert into TB_STOCK Values (1006,15,15,0);

Insert into TB_STOCK Values (1007,14,15,1);

Insert into TB_STOCK Values (1008,18,18,0);

Insert into TB_STOCK Values (1009,14,15,1);

Insert into TB_STOCK Values (1010,15,15,0);

Insert into TB_STOCK Values (1011,6,9,3);

Insert into TB_STOCK Values (1012,9,9,0);

Insert into TB_STOCK Values (1013,8,8,0);

Insert into TB_STOCK Values (1014,19,19,0);

Insert into TB_STOCK Values (1015,9,10,1);

Insert into TB_STOCK Values (1016,11,12,1);

Insert into TB_STOCK Values (1017,14,15,1);

Insert into TB_STOCK Values (1018,7,8,1);

Insert into TB_STOCK Values (1019,35,36,1);

Insert into TB_STOCK Values (1020,4,4,0);

Insert into TB_STOCK Values (1021,13,13,0);

Insert into TB_STOCK Values (1022,20,20,0);

Insert into TB_STOCK Values (1023,21,25,4);

Insert into TB_STOCK Values (1024,40,40,0);

Insert into TB_STOCK Values (1025,13,13,0);

Insert into TB_STOCK Values (1026,19,19,0);

Insert into TB_STOCK Values (1027,33,35,2);

Insert into TB_STOCK Values (1028,12,13,1);

Insert into TB_STOCK Values (1029,9,9,0);

Insert into TB_STOCK Values (1030,15,16,1);

Insert into TB_STOCK Values (1031,25,25,0);

Insert into TB_STOCK Values (1032,8,8,0);

Insert into TB_STOCK Values (1033,9,10,1);

Insert into TB_STOCK Values (1043,14,14,0);

Insert into TB_STOCK Values (1110,6,7,1);

Insert into TB_STOCK Values (1111,13,15,2);

Insert into TB_STOCK Values (1112,15,16,1);

Insert into TB_STOCK Values (1113,13,14,1);

Insert into TB_STOCK Values (1114,19,20,1);

Insert into TB_STOCK Values (1115,20,20,0);

Insert into TB_STOCK Values (1116,19,23,4);

Insert into TB_STOCK Values (1117,22,22,0);

Insert into TB_STOCK Values (1118,6,8,2);

Insert into TB_STOCK Values (1119,8,12,4);






Insert into TB_LIBRO Values ('978-1-4614-3522-8','Ceramic Materials','Ceramic Materials',
'Models Ceramic',2003,123,6,'Dura',1,1015,38000,71900,'Che','Pub');

Insert into TB_LIBRO Values ('978-1-4614-4111-3','Autism and the Brain','Autism and the Brain',
'His',2002,50,2,'Dura',1,1114,17500,58500,'Beh','Tem');

Insert into TB_LIBRO Values ('978-1-4614-4390-2','Burnout for Experts','Burnout for Experts',
'Burnot',2004,100,2,'Suave',2,1116,46800,72500,'Beh','Col');

Insert into TB_LIBRO Values ('978-1-4614-4450-3','Clinical Psychology and Psychotherapy as a Science',
'Clinical Psychology and Psychotherapy as a Science','Show how afects',2012,105,1,'Dura',6,1110,58500,117000,'Beh','Apl');

Insert into TB_LIBRO Values ('978-1-4614-5063-4','Towards Understanding the Climate of Venus',
'Towards Understanding the Climate of Venus',' Understanding the Climate of Venus',1995,30,9,'Suave',
3,1027,45600,117500,'Phy','Com');

Insert into TB_LIBRO Values ('978-1-4614-5084-9','Thermodynamics of Crystalline States',
'Thermodynamics of Crystalline States','Thermodynamics of Crystalline States',
2015,345,4,'Suave',1,1032,52600,292000,'Phy','Deb');

Insert into TB_LIBRO Values ('978-1-4614-5353-6','The Stones and the Stars','The Stones and the Stars',
'The Stones and the Stars',2014,45,3,'Dura',6,1020,39000,187000,'Phy','Edi');

Insert into TB_LIBRO Values ('978-1-4614-5362-8','The Story of Helium and the Birth of Astrophysics',
'The Story of Helium and the Birth of Astrophysics','elium and the Birth of Astrophysics',
2003,30,6,'Suave',2,1021,26300,73100,'Phy','Comp');

Insert into TB_LIBRO Values ('978-1-4614-5446-5','Clinical Guide to Mental Disability Evaluations',
'Clinical Guide to Mental Disability Evaluations','Evaluations ',
2005,50,2,'Dura',3,1113,11700,46800,'Beh','Pat');

Insert into TB_LIBRO Values ('978-1-4614-5458-8','The Soyuz Launch Vehicle','The Soyuz Launch Vehicle',
'The Soyuz Launch Vehicle',2005,75,8,'Suave',3,1022,57300,73000,'Phy','Pat');

Insert into TB_LIBRO Values ('978-1-4614-5698-8','Three Dimensional Solar Cells Based on O.C.G',
'Three Dimensional Solar Cells Based on O.C.G','Cells Based on Optical Confinement Geometries',2004,98,4,
'Suave',1,1028,52600,96000,'Phy','Wil');

Insert into TB_LIBRO Values ('978-1-4614-5965-1','Tissue F. and R in the Circulatory and V.S',
'Tissue F. and R in the Circulatory and V.S','Remodeling in the Circulatory and Ventilatory Systems',
2010,94,2,'Suave',4,1024,52000,71900,'Phy','Uni');

Insert into TB_LIBRO Values ('978-1-4614-6223-1','The Theoretical Foundations of Q.M',
'The Theoretical Foundations of Q.M','The Theoretical Foundations',2011,350,12,'Dura',
5,1030,32700,71900,'Phy','Grijalbo');

Insert into TB_LIBRO Values ('978-1-4614-6242-2','Advances in Dynamic Network Modeling in Complex Systems',
'Advances in Dynamic Network Modeling in Complex Systems',
'Advances in Dynamic Network Modeling in Complex',1995,76,2,'Suave',4,1007,52000,117000,'Bus','Tem');

Insert into TB_LIBRO Values ('978-1-4614-6302-3','Anti-Poverty Psychology',
'Anti-Poverty Psychology','Making Psychology',1998,105,2,'Suave',3,1117,52000,117000,'Beh','Con');

Insert into TB_LIBRO Values ('978-1-4614-6321-4','Advances in Metaheuristics',
'Advances in Metaheuristics','Advances in Metaheuristics',2001,90,1,'Suave',5,1008,19800,72000,'Bus','Uni');

Insert into TB_LIBRO Values ('978-1-4614-6740-3','Adolescents, Crime, and the Media',
'Adolescents, Crime, and the Media','Media and Desc',2013,83,2,'Suave',2,1111,29200,87700,'Beh','Bea');

Insert into TB_LIBRO Values ('978-3-319-00073-2','Towards Solid-State Quantum Repeaters',
'Towards Solid-State Quantum Repeaters','Towards Solid-State ',2012,100,10,'Dura',2,1029,25100,226000,'Phy','Pub');

Insert into TB_LIBRO Values ('978-3-642-29745-8','Towards Practical Brain-Computer Interfaces',
'Towards Practical Brain-Computer Interfaces','Towards Practical Brain-Compute',2009,80,9,'Dura',
1,1023,20400,119000,'Phy','Tem');

Insert into TB_LIBRO Values ('978-3-642-30935-9','Theory of Bilayer Graphene Spectroscopy',
'Theory of Bilayer Graphene Spectroscopy','Theory of Bilayer ',2016,123,3,'Suave',
6,1031,45600,155000,'Phy','Con');

Insert into TB_LIBRO Values ('978-3-642-30984-7','Conservation Science for the Cultural Heritage',
'Conservation Science for the Cultural Heritage','Conservation Science ',
2014,123,5,'Dura',6,1012,31500,71900,'Che','Com');

Insert into TB_LIBRO Values ('978-3-642-31022-5','Approaching Business Models from an Economic Perspective',
'Approaching Business Models from an Economic Perspective','Approaching Business ',
2005,23,3,'Suave',3,1002,84800,117000,'Bus','Grijalbo');

Insert into TB_LIBRO Values ('978-3-642-31469-8','Characterization and Development of Biosystems',
'Characterization and Development of Biosystems','Characterization and Development',
2005,123,6,'Dura',5,1013,32700,117000,'Che','Wil');

Insert into TB_LIBRO Values ('978-3-642-32294-5','Design and Analysis of Materials and Engineering Structures',
'Design and Analysis of Materials and Engineering Structures',' Materials and Engineering Structures',
2001,286,9,'Suave',3,1017,20400,154000,'Che','Comp');

Insert into TB_LIBRO Values ('978-3-642-32328-7','Designing Receptors for the Next Generation of Biosensors',
'Designing Receptors for the Next Generation of Biosensors','Next Generation of Biosensors',
2006,300,5,'Suave',4,1014,57300,143000,'Che','Pub');

Insert into TB_LIBRO Values ('978-3-642-34632-3','The Vitreous State','The Vitreous State',
'The Vitreous State',1992,45,6,'Dura',2,1026,32700,91200,'Phy','Comp');

Insert into TB_LIBRO Values ('978-3-642-34909-6','International Conference on IT and MS ICITMS',
'International Conference on IT and MS ICITMS','International Conference on Information Technology',
2010,220,1,'Suave',2,1005,26300,101000,'Bus','Wil');

Insert into TB_LIBRO Values ('978-3-642-34918-8','Allocating Taxing Powers within the European Union',
'Allocating Taxing Powers within the European Union','Allocating Taxing',
2005,200,2,'Suave',5,1004,30200,91260,'Bus','Com');

Insert into TB_LIBRO Values ('978-3-642-35760-2','Accounting Information Systems for Decision Making',
'Accounting Information Systems for Decision Making','Accouting Information ',
2009,120,3,'Dura',5,1118,45000,71900,'Bus','Deb');

Insert into TB_LIBRO Values ('978-3-642-35903-3','A Guide to Continuous Improvement Transformation',
'A Guide to Continuous Improvement Transformation','Improvement Transformation',
2013,204,3,'Dura',2,1010,45630,72500,'Bus','Pat');

Insert into TB_LIBRO Values ('978-3-642-36457-0','Characterisation of Areal Surface Texture',
'Characterisation of Areal Surface Texture','Areal Surface Texture',
2002,245,7,'Suave',2,1016,19800,136000,'Che','Edi');

Insert into TB_LIBRO Values ('978-3-642-36523-2','A Course in In-Memory Data Management',
'A Course in In-Memory Data Management','Course in In-Memory Data Management',
1985,55,2,'Suave',1,1001,36000,84800,'Bus','Deb');

Insert into TB_LIBRO Values ('978-3-658-00698-3','A Liner Shipping Network Design',
'A Liner Shipping Network Design','A Liner Shipping ',
2013,203,1,'Dura',1,1009,100000,201000,'Bus','Bea');

Insert into TB_LIBRO Values ('978-3-658-02166-5','Asset Allocation Considerations for Pension Insurance Funds',
'Asset Allocation Considerations for Pension Insurance Funds',' Pension Insurance Funds',
1997,50,1,'Suave',6,1119,37000,76000,'Bus','Con');

Insert into TB_LIBRO Values ('978-3-8349-3356-0','A Strategic Fit Perspective on Family Firm Performance',
'A Strategic Fit Perspective on Family Firm Performance','A Strategic Fit Perspective',
1998,75,3,'Dura',6,1006,39100,78300,'Bus','Pat');

Insert into TB_LIBRO Values ('978-4-431-54167-7','Thermodynamics of Information Processing in Small Systems',
'Thermodynamics of Information Processing in Small Systems','Information Processing in Small Systems',
2014,124,8,'Suave',2,1033,32700,84800,'Phy','Grijalbo');

Insert into TB_LIBRO Values ('978-4-431-54230-8','Development of Novel Hydrogen-Bond Donor',
'Development of Novel Hydrogen-Bond Donor','Development of Novel Hydrogen-Bond',
1998,89,12,'Dura',4,1018,45600,137000,'Che','Con');

Insert into TB_LIBRO Values ('978-4-431-54317-6','A Bayesian Analysis of QCD Sum Rules',
'A Bayesian Analysis of QCD Sum Rules',' QCD Sum Rules',
2013,67,9,'Suave',4,1043,52000,99400,'Phy','Pub');

Insert into TB_LIBRO Values ('978-81-322-0719-1','Corrosion of Constructional Steels in M. and IE',
'Corrosion of Constructional Steels in M. and IE','Corrosion of Constructional Steels',
1995,40,4,'Suave',5,1019,26000,72500,'Che','Tem');

Insert into TB_LIBRO Values ('978-81-322-0732-0','Asian Space Race: Rhetoric or Reality?',
'Asian Space Race: Rhetoric or Reality?','Rhetoric or Reality?',
2009,208,4,'Suave',3,1011,44400,117000,'Bus','Com');

Insert into TB_LIBRO Values ('978-88-470-2690-2','Theory of Gravitational Interactions',
'Theory of Gravitational Interactions','Gravitational Interactions',
2013,87,5,'Suave',5,1025,30000,90000,'Phy','Edi');

Insert into TB_LIBRO Values ('978-88-470-2723-7','Aspetti psicologici nella sclerosi multipla',
'Aspetti psicologici nella sclerosi multipla','Scleroli',
1996,67,4,'Dura',2,1115,234000,351000,'Beh','Uni');

Insert into TB_LIBRO Values ('978-94-007-4932-0','Agent-Based Modelling of Socio-Technical Systems',
'Agent-Based Modelling of Socio-Technical Systems','Modelling of Socio-Technical Systems',
2005,123,2,'Suave',4,1003,36300,71900,'Bus','Uni');

Insert into TB_LIBRO Values ('978-94-007-5570-3','Analyzing and Theorizing the Dynamics',
'Analyzing and Theorizing the Dynamics','Workplace',
2012,55,1,'Dura',1,1112,160000,292500,'Beh','Col');








Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-4450-3','Luc');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-6740-3','Chr');

Insert into TB_AUTOR_LIBRO
Values ('978-94-007-5570-3','Mic');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5446-5','Liz');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-4111-3','Tat');

Insert into TB_AUTOR_LIBRO
Values ('978-88-470-2723-7','Sil');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-4390-2','Sab');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-6302-3','Stu');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-35760-2','Dan');

Insert into TB_AUTOR_LIBRO
Values ('978-3-658-02166-5','Chri');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-36523-2','Has');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-31022-5','Wei');

Insert into TB_AUTOR_LIBRO
Values ('978-94-007-4932-0','Koe');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-34918-8','Isa');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-34909-6','Bin');

Insert into TB_AUTOR_LIBRO
Values ('978-3-8349-3356-0','Cor');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-6242-2','Sat');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-6321-4','Luc');

Insert into TB_AUTOR_LIBRO
Values ('978-3-658-00698-3','Vol');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-35903-3','Ari');

Insert into TB_AUTOR_LIBRO
Values ('978-81-322-0732-0','Aje');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-30984-7','Wei');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-31469-8','Isa');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-32328-7','Has');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-3522-8','Luc');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-36457-0','Koe');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-32294-5','Chri');

Insert into TB_AUTOR_LIBRO
Values ('978-4-431-54230-8','Ari');

Insert into TB_AUTOR_LIBRO
Values ('978-81-322-0719-1','Aje');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5353-6','Cor');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5362-8','Dan');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5458-8','Vol');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-29745-8','Has');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5965-1','Stu');

Insert into TB_AUTOR_LIBRO
Values ('978-88-470-2690-2','Vol');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-34632-3','Has');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5063-4','Vol');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5698-8','Mic');

Insert into TB_AUTOR_LIBRO
Values ('978-3-319-00073-2','Ari');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-6223-1','Bin');

Insert into TB_AUTOR_LIBRO
Values ('978-3-642-30935-9','Ari');

Insert into TB_AUTOR_LIBRO
Values ('978-1-4614-5084-9','Cor');

Insert into TB_AUTOR_LIBRO
Values ('978-4-431-54167-7','Chr');

Insert into TB_AUTOR_LIBRO
Values ('978-4-431-54317-6','Phi');







Insert into TB_TEMA_LIBRO
Values ('978-1-4614-4450-3','Cli');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-6740-3','Dev');


Insert into TB_TEMA_LIBRO
Values ('978-94-007-5570-3','Ind');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5446-5','Ind');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-4111-3','Psy');


Insert into TB_TEMA_LIBRO
Values ('978-88-470-2723-7','Psyc');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-4390-2','Psyc');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-6302-3','Soc');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-35760-2','Acc');


Insert into TB_TEMA_LIBRO
Values ('978-3-658-02166-5','Ban');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-36523-2','Dat');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-31022-5','Eco');


Insert into TB_TEMA_LIBRO
Values ('978-94-007-4932-0','Ene');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-34918-8','Eur');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-34909-6','Inf');


Insert into TB_TEMA_LIBRO
Values ('978-3-8349-3356-0','Lea');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-6242-2','Ope');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-6321-4','Ope');


Insert into TB_TEMA_LIBRO
Values ('978-3-658-00698-3','Pro');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-35903-3','Qua');


Insert into TB_TEMA_LIBRO
Values ('978-81-322-0732-0','Tec');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-30984-7','Ana');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-31469-8','Bio');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-32328-7','Bioo');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-3522-8','Cer');

Insert into TB_TEMA_LIBRO
Values ('978-3-642-36457-0','Cha');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-32294-5','Cha');


Insert into TB_TEMA_LIBRO
Values ('978-4-431-54230-8','Org');


Insert into TB_TEMA_LIBRO
Values ('978-81-322-0719-1','Str');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5353-6','His');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5362-8','His');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5458-8','Aer');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-29745-8','Biom');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5965-1','Biop');


Insert into TB_TEMA_LIBRO
Values ('978-88-470-2690-2','Cla');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-34632-3','Con');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5063-4','Ext');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5698-8','Opt');


Insert into TB_TEMA_LIBRO
Values ('978-3-319-00073-2','Quan');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-6223-1','Quant');


Insert into TB_TEMA_LIBRO
Values ('978-3-642-30935-9','Spe');


Insert into TB_TEMA_LIBRO
Values ('978-1-4614-5084-9','The');


Insert into TB_TEMA_LIBRO
Values ('978-4-431-54167-7','The');

Insert into TB_TEMA_LIBRO
Values ('978-4-431-54317-6','The');




Insert into TB_HACIENTO_CONTABLE Values (0,'2017-06-22',842700,407500,435200);

Insert into TB_HACIENTO_CONTABLE Values (1,'2017-06-30',534900,150400,384500);

Insert into TB_HACIENTO_CONTABLE Values (2,'2017-07-12',370200,163600,206600);

Insert into TB_HACIENTO_CONTABLE Values (3,'2017-07-28',746800,364700,382100);

Insert into TB_HACIENTO_CONTABLE Values (4,'2017-08-03',797400,391700,405700);

Insert into TB_HACIENTO_CONTABLE Values (5,'2017-08-08',630000,126600,503400);





Insert into TB_CLIENTE Values ('000000000','Default','Default','Default',0);

Insert into TB_CLIENTE Values ('1-1254-7896','Jose','Fernadez','Lopez',48848445);

Insert into TB_CLIENTE Values ('1-4646-5464','Emilio','Esteban','Torres',64686844);

Insert into TB_CLIENTE Values ('1-4668-4624','Calos','Moreno','Moreno',46486484);

Insert into TB_CLIENTE Values ('1-9650-0154','Pedro','Porras','Perez',46464484);

Insert into TB_CLIENTE Values ('2-4445-6565','Vilma','Rodrigues','Mora',46464654);

Insert into TB_CLIENTE Values ('2-4568-7952','David','Gamboa','Ocampo',48468468);

Insert into TB_CLIENTE Values ('4-4645-4645','Andre','Cordero','Conejo',84864884);

Insert into TB_CLIENTE Values ('4-8466-7895','Maria','Lopez','Castro',84846848);

Insert into TB_CLIENTE Values ('6-7954-8464','Jose','Ulloa','Garcia',54844848);




Insert into TB_ENCABEZADO Values (0,'2017-06-22',536800,69784,606584,'1-1254-7896',0);

Insert into TB_ENCABEZADO Values (1,'2017-06-22',305900,39767,345667,'2-4568-7952',0);

Insert into TB_ENCABEZADO Values (2,'2017-06-30',298400,38792,337192,'000000000',1);

Insert into TB_ENCABEZADO Values (3,'2017-06-30',236500,30745,267245,'000000000',1);

Insert into TB_ENCABEZADO Values (4,'2017-07-12',213500,27755,241255,'1-4668-4624',2);

Insert into TB_ENCABEZADO Values (5,'2017-07-12',156700,20371,177071,'4-8466-7895',2);

Insert into TB_ENCABEZADO Values (6,'2017-07-28',526400,68432,594832,'6-7954-8464',3);

Insert into TB_ENCABEZADO Values (7,'2017-07-28',220400,28652,249052,'4-4645-4645',3);

Insert into TB_ENCABEZADO Values (8,'2017-08-03',261400,33982,295382,'1-4646-5464',4);

Insert into TB_ENCABEZADO Values (9,'2017-08-03',536000,69680,605680,'2-4445-6565',4);

Insert into TB_ENCABEZADO Values (10,'2017-08-08',630000,81900,711900,'1-9650-0154',5);








Insert into TB_DETALLE Values (0,'978-1-4614-4390-2',2,72500,145000);

Insert into TB_DETALLE Values (0,'978-1-4614-4450-3',1,117000,117000);

Insert into TB_DETALLE Values (0,'978-1-4614-5446-5',1,46800,46800);

Insert into TB_DETALLE Values (0,'978-3-658-02166-5',3,76000,228000);

Insert into TB_DETALLE Values (1,'978-1-4614-6242-2',1,117000,117000);

Insert into TB_DETALLE Values (1,'978-81-322-0732-0',1,117000,117000);

Insert into TB_DETALLE Values (1,'978-94-007-4932-0',1,71900,71900);

Insert into TB_DETALLE Values (2,'978-1-4614-3522-8',1,71900,71900);

Insert into TB_DETALLE Values (2,'978-3-642-32294-5',1,154000,154000);

Insert into TB_DETALLE Values (2,'978-81-322-0719-1',1,72500,72500);

Insert into TB_DETALLE Values (3,'978-1-4614-5063-4',1,117500,117500);

Insert into TB_DETALLE Values (3,'978-3-642-29745-8',1,119000,119000);

Insert into TB_DETALLE Values (4,'978-1-4614-5063-4',1,117500,117500);

Insert into TB_DETALLE Values (4,'978-1-4614-5698-8',1,96000,96000);

Insert into TB_DETALLE Values (5,'978-1-4614-6223-1',1,71900,71900);

Insert into TB_DETALLE Values (5,'978-4-431-54167-7',1,84800,84800);

Insert into TB_DETALLE Values (6,'978-1-4614-4111-3',1,58500,58500);

Insert into TB_DETALLE Values (6,'978-1-4614-6740-3',2,87700,175400);

Insert into TB_DETALLE Values (6,'978-94-007-5570-3',1,292500,292500);

Insert into TB_DETALLE Values (7,'978-1-4614-4390-2',1,72500,72500);

Insert into TB_DETALLE Values (7,'978-3-642-35760-2',1,71900,71900);

Insert into TB_DETALLE Values (7,'978-3-658-02166-5',1,76000,76000);

Insert into TB_DETALLE Values (8,'978-1-4614-4390-2',1,72500,72500);

Insert into TB_DETALLE Values (8,'978-3-642-31022-5',1,117000,117000);

Insert into TB_DETALLE Values (8,'978-3-642-35760-2',1,71900,71900);

Insert into TB_DETALLE Values (9,'978-3-642-34909-6',1,101000,101000);

Insert into TB_DETALLE Values (9,'978-3-658-00698-3',1,201000,201000);

Insert into TB_DETALLE Values (9,'978-81-322-0732-0',2,117000,234000);

Insert into TB_DETALLE Values (10,'978-3-642-29745-8',3,119000,357000);

Insert into TB_DETALLE Values (10,'978-3-642-36457-0',1,136000,136000);

Insert into TB_DETALLE Values (10,'978-4-431-54230-8',1,137000,137000);













