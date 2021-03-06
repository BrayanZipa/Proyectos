PGDMP     :                 	    y            consultoriomedico    13.4    13.4 2    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    17225    consultoriomedico    DATABASE     p   CREATE DATABASE consultoriomedico WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
 !   DROP DATABASE consultoriomedico;
                postgres    false            ?            1259    17245    Functionary    TABLE     <  CREATE TABLE public."Functionary" (
    id integer NOT NULL,
    identification character varying(20),
    email character varying(100),
    password character varying(30),
    name character varying(50),
    "lastName" character varying(50),
    "position" character varying(25),
    phone character varying(10)
);
 !   DROP TABLE public."Functionary";
       public         heap    postgres    false            ?            1259    17243    Functionary_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Functionary_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Functionary_id_seq";
       public          postgres    false    203            ?           0    0    Functionary_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public."Functionary_id_seq" OWNED BY public."Functionary".id;
          public          postgres    false    202            ?            1259    17269    MedicalAppointmentHistory    TABLE     '  CREATE TABLE public."MedicalAppointmentHistory" (
    id integer NOT NULL,
    patient_id integer,
    functionary_id integer,
    "requestDate" date,
    "applicationDate" date,
    "applicationHour" time without time zone,
    observation character varying,
    state character varying(10)
);
 /   DROP TABLE public."MedicalAppointmentHistory";
       public         heap    postgres    false            ?            1259    17267     MedicalAppointmentHistory_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."MedicalAppointmentHistory_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."MedicalAppointmentHistory_id_seq";
       public          postgres    false    207            ?           0    0     MedicalAppointmentHistory_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public."MedicalAppointmentHistory_id_seq" OWNED BY public."MedicalAppointmentHistory".id;
          public          postgres    false    206            ?            1259    17259    Medicine    TABLE     ?   CREATE TABLE public."Medicine" (
    id integer NOT NULL,
    "uniqueCode" character varying(30),
    name character varying(30),
    supplier character varying(30),
    price double precision,
    quantity integer
);
    DROP TABLE public."Medicine";
       public         heap    postgres    false            ?            1259    17290    MedicineControl    TABLE     ?   CREATE TABLE public."MedicineControl" (
    id integer NOT NULL,
    medicine_id integer,
    functionary_id integer,
    "registerType" character varying,
    quantity integer,
    date date,
    hour time without time zone
);
 %   DROP TABLE public."MedicineControl";
       public         heap    postgres    false            ?            1259    17288    MedicineControl_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."MedicineControl_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."MedicineControl_id_seq";
       public          postgres    false    209            ?           0    0    MedicineControl_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."MedicineControl_id_seq" OWNED BY public."MedicineControl".id;
          public          postgres    false    208            ?            1259    17257    Medicine_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Medicine_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public."Medicine_id_seq";
       public          postgres    false    205            ?           0    0    Medicine_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public."Medicine_id_seq" OWNED BY public."Medicine".id;
          public          postgres    false    204            ?            1259    17228    Patient    TABLE     ?  CREATE TABLE public."Patient" (
    id integer NOT NULL,
    name character varying(50),
    "lastName" character varying(50),
    identification character varying(20),
    birthdate date,
    age character varying(3),
    genre character varying,
    phone character varying(10),
    district character varying(30),
    address character varying(30),
    "bloodType" character varying,
    email character varying(100),
    password character varying(30),
    state boolean
);
    DROP TABLE public."Patient";
       public         heap    postgres    false            ?            1259    17226    Patient_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Patient_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Patient_id_seq";
       public          postgres    false    201            ?           0    0    Patient_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public."Patient_id_seq" OWNED BY public."Patient".id;
          public          postgres    false    200            >           2604    17248    Functionary id    DEFAULT     t   ALTER TABLE ONLY public."Functionary" ALTER COLUMN id SET DEFAULT nextval('public."Functionary_id_seq"'::regclass);
 ?   ALTER TABLE public."Functionary" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            @           2604    17272    MedicalAppointmentHistory id    DEFAULT     ?   ALTER TABLE ONLY public."MedicalAppointmentHistory" ALTER COLUMN id SET DEFAULT nextval('public."MedicalAppointmentHistory_id_seq"'::regclass);
 M   ALTER TABLE public."MedicalAppointmentHistory" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            ?           2604    17262    Medicine id    DEFAULT     n   ALTER TABLE ONLY public."Medicine" ALTER COLUMN id SET DEFAULT nextval('public."Medicine_id_seq"'::regclass);
 <   ALTER TABLE public."Medicine" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            A           2604    17293    MedicineControl id    DEFAULT     |   ALTER TABLE ONLY public."MedicineControl" ALTER COLUMN id SET DEFAULT nextval('public."MedicineControl_id_seq"'::regclass);
 C   ALTER TABLE public."MedicineControl" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            =           2604    17231 
   Patient id    DEFAULT     l   ALTER TABLE ONLY public."Patient" ALTER COLUMN id SET DEFAULT nextval('public."Patient_id_seq"'::regclass);
 ;   ALTER TABLE public."Patient" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            ?          0    17245    Functionary 
   TABLE DATA           q   COPY public."Functionary" (id, identification, email, password, name, "lastName", "position", phone) FROM stdin;
    public          postgres    false    203   P@       ?          0    17269    MedicalAppointmentHistory 
   TABLE DATA           ?   COPY public."MedicalAppointmentHistory" (id, patient_id, functionary_id, "requestDate", "applicationDate", "applicationHour", observation, state) FROM stdin;
    public          postgres    false    207   EA       ?          0    17259    Medicine 
   TABLE DATA           W   COPY public."Medicine" (id, "uniqueCode", name, supplier, price, quantity) FROM stdin;
    public          postgres    false    205   ?A       ?          0    17290    MedicineControl 
   TABLE DATA           r   COPY public."MedicineControl" (id, medicine_id, functionary_id, "registerType", quantity, date, hour) FROM stdin;
    public          postgres    false    209   CB       ?          0    17228    Patient 
   TABLE DATA           ?   COPY public."Patient" (id, name, "lastName", identification, birthdate, age, genre, phone, district, address, "bloodType", email, password, state) FROM stdin;
    public          postgres    false    201   `B       ?           0    0    Functionary_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."Functionary_id_seq"', 5, true);
          public          postgres    false    202            ?           0    0     MedicalAppointmentHistory_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public."MedicalAppointmentHistory_id_seq"', 5, true);
          public          postgres    false    206            ?           0    0    MedicineControl_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."MedicineControl_id_seq"', 1, true);
          public          postgres    false    208            ?           0    0    Medicine_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Medicine_id_seq"', 4, true);
          public          postgres    false    204            ?           0    0    Patient_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Patient_id_seq"', 5, true);
          public          postgres    false    200            K           2606    17254 !   Functionary Functionary_email_key 
   CONSTRAINT     a   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_email_key" UNIQUE (email);
 O   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_email_key";
       public            postgres    false    203            M           2606    17252 *   Functionary Functionary_identification_key 
   CONSTRAINT     s   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_identification_key" UNIQUE (identification);
 X   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_identification_key";
       public            postgres    false    203            O           2606    17256 !   Functionary Functionary_phone_key 
   CONSTRAINT     a   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_phone_key" UNIQUE (phone);
 O   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_phone_key";
       public            postgres    false    203            Q           2606    17250    Functionary Functionary_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_pkey" PRIMARY KEY (id);
 J   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_pkey";
       public            postgres    false    203            W           2606    17277 8   MedicalAppointmentHistory MedicalAppointmentHistory_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_pkey" PRIMARY KEY (id);
 f   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_pkey";
       public            postgres    false    207            Y           2606    17298 $   MedicineControl MedicineControl_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_pkey" PRIMARY KEY (id);
 R   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_pkey";
       public            postgres    false    209            S           2606    17264    Medicine Medicine_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Medicine"
    ADD CONSTRAINT "Medicine_pkey" PRIMARY KEY (id);
 D   ALTER TABLE ONLY public."Medicine" DROP CONSTRAINT "Medicine_pkey";
       public            postgres    false    205            U           2606    17266     Medicine Medicine_uniqueCode_key 
   CONSTRAINT     g   ALTER TABLE ONLY public."Medicine"
    ADD CONSTRAINT "Medicine_uniqueCode_key" UNIQUE ("uniqueCode");
 N   ALTER TABLE ONLY public."Medicine" DROP CONSTRAINT "Medicine_uniqueCode_key";
       public            postgres    false    205            C           2606    17242    Patient Patient_email_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_email_key" UNIQUE (email);
 G   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_email_key";
       public            postgres    false    201            E           2606    17238 "   Patient Patient_identification_key 
   CONSTRAINT     k   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_identification_key" UNIQUE (identification);
 P   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_identification_key";
       public            postgres    false    201            G           2606    17240    Patient Patient_phone_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_phone_key" UNIQUE (phone);
 G   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_phone_key";
       public            postgres    false    201            I           2606    17236    Patient Patient_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_pkey";
       public            postgres    false    201            [           2606    17283 G   MedicalAppointmentHistory MedicalAppointmentHistory_functionary_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_functionary_id_fkey" FOREIGN KEY (functionary_id) REFERENCES public."Functionary"(id);
 u   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_functionary_id_fkey";
       public          postgres    false    203    207    2897            Z           2606    17278 C   MedicalAppointmentHistory MedicalAppointmentHistory_patient_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_patient_id_fkey" FOREIGN KEY (patient_id) REFERENCES public."Patient"(id);
 q   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_patient_id_fkey";
       public          postgres    false    2889    201    207            ]           2606    17304 3   MedicineControl MedicineControl_functionary_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_functionary_id_fkey" FOREIGN KEY (functionary_id) REFERENCES public."Functionary"(id);
 a   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_functionary_id_fkey";
       public          postgres    false    2897    209    203            \           2606    17299 0   MedicineControl MedicineControl_medicine_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_medicine_id_fkey" FOREIGN KEY (medicine_id) REFERENCES public."Medicine"(id) ON UPDATE CASCADE ON DELETE CASCADE;
 ^   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_medicine_id_fkey";
       public          postgres    false    205    209    2899            ?   ?   x?]?An? E??)r3?]?zo?.??UHv?H?hN???M]?`?|?|?yZ?/?(??????9]??y?3<$?i????{?s?2??ݐ???)?Vh??G?????t?7R????U?0T?M|b???B????:????e?˴!V??޸?m>픩a ?#???9K???%?`c?ۧ?sfo]O?W2?????x??¨oU?Xkx_?O???????C
!??z}B      ?   }   x?m?=
?0??Y:?/??O?Oɖ?YB???֡????-??E<??zRQDH??JDI$?I?G??ǝSmQ????v-?????6?I???yǺe{?????Ƕ???s?<J-4?\?\x?1??m-?      ?   a   x?e?;
?0????@?D`c????#Yp?Dm<???S??x4ǦYR\??R??AD .@:K[???h??Q٘N???SA*?̌???V??X:??? ?      ?      x?????? ? ?      ?   V  x?m?Mk?0??ʯȽ??S?ok7Z(+?????????#;??On??`G??}?H?~?k??+g?h??e?b܁԰k?=??P?F4?p?/?_^??D[??=];?u;?R-??a*?unZ85?44_???A??@Ǹ`AJ???]??`e???8ѷmS??%???Y??X?!??T?:bj8P??=??p?BI?ī?N1?@?\0??.?S??>??2?>???x?P????2???????eJ\?6Yr?sKnT?? ???>?LQ{?%5?>:??:???+L????o?ٷ?͇??eL?&??4 ???i?fDm?SW??6t??ȆX??H?????l??s     