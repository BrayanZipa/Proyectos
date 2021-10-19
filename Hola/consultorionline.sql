PGDMP     &                 	    y            consultorionline    13.4    13.4 ;    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16822    consultorionline    DATABASE     o   CREATE DATABASE consultorionline WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
     DROP DATABASE consultorionline;
                postgres    false            �            1259    16887    FormulatedMedicine    TABLE     w   CREATE TABLE public."FormulatedMedicine" (
    id integer NOT NULL,
    patient_id integer,
    medicine_id integer
);
 (   DROP TABLE public."FormulatedMedicine";
       public         heap    postgres    false            �            1259    16885    FormulatedMedicine_id_seq    SEQUENCE     �   CREATE SEQUENCE public."FormulatedMedicine_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public."FormulatedMedicine_id_seq";
       public          postgres    false    209            �           0    0    FormulatedMedicine_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public."FormulatedMedicine_id_seq" OWNED BY public."FormulatedMedicine".id;
          public          postgres    false    208            �            1259    16842    Functionary    TABLE     <  CREATE TABLE public."Functionary" (
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
       public         heap    postgres    false            �            1259    16840    Functionary_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Functionary_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Functionary_id_seq";
       public          postgres    false    203            �           0    0    Functionary_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public."Functionary_id_seq" OWNED BY public."Functionary".id;
          public          postgres    false    202            �            1259    16866    MedicalAppointmentHistory    TABLE     '  CREATE TABLE public."MedicalAppointmentHistory" (
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
       public         heap    postgres    false            �            1259    16864     MedicalAppointmentHistory_id_seq    SEQUENCE     �   CREATE SEQUENCE public."MedicalAppointmentHistory_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."MedicalAppointmentHistory_id_seq";
       public          postgres    false    207            �           0    0     MedicalAppointmentHistory_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public."MedicalAppointmentHistory_id_seq" OWNED BY public."MedicalAppointmentHistory".id;
          public          postgres    false    206            �            1259    16856    Medicine    TABLE     �   CREATE TABLE public."Medicine" (
    id integer NOT NULL,
    "uniqueCode" character varying(30),
    name character varying(30),
    supplier character varying(30),
    price double precision,
    quantity integer
);
    DROP TABLE public."Medicine";
       public         heap    postgres    false            �            1259    16905    MedicineControl    TABLE     �   CREATE TABLE public."MedicineControl" (
    id integer NOT NULL,
    medicine_id integer,
    functionary_id integer,
    "registerType" character varying,
    quantity integer,
    date date,
    hour time without time zone
);
 %   DROP TABLE public."MedicineControl";
       public         heap    postgres    false            �            1259    16903    MedicineControl_id_seq    SEQUENCE     �   CREATE SEQUENCE public."MedicineControl_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public."MedicineControl_id_seq";
       public          postgres    false    211                        0    0    MedicineControl_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public."MedicineControl_id_seq" OWNED BY public."MedicineControl".id;
          public          postgres    false    210            �            1259    16854    Medicine_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Medicine_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public."Medicine_id_seq";
       public          postgres    false    205                       0    0    Medicine_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public."Medicine_id_seq" OWNED BY public."Medicine".id;
          public          postgres    false    204            �            1259    16825    Patient    TABLE     �  CREATE TABLE public."Patient" (
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
       public         heap    postgres    false            �            1259    16823    Patient_id_seq    SEQUENCE     �   CREATE SEQUENCE public."Patient_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Patient_id_seq";
       public          postgres    false    201                       0    0    Patient_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public."Patient_id_seq" OWNED BY public."Patient".id;
          public          postgres    false    200            G           2604    16890    FormulatedMedicine id    DEFAULT     �   ALTER TABLE ONLY public."FormulatedMedicine" ALTER COLUMN id SET DEFAULT nextval('public."FormulatedMedicine_id_seq"'::regclass);
 F   ALTER TABLE public."FormulatedMedicine" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            D           2604    16845    Functionary id    DEFAULT     t   ALTER TABLE ONLY public."Functionary" ALTER COLUMN id SET DEFAULT nextval('public."Functionary_id_seq"'::regclass);
 ?   ALTER TABLE public."Functionary" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            F           2604    16869    MedicalAppointmentHistory id    DEFAULT     �   ALTER TABLE ONLY public."MedicalAppointmentHistory" ALTER COLUMN id SET DEFAULT nextval('public."MedicalAppointmentHistory_id_seq"'::regclass);
 M   ALTER TABLE public."MedicalAppointmentHistory" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            E           2604    16859    Medicine id    DEFAULT     n   ALTER TABLE ONLY public."Medicine" ALTER COLUMN id SET DEFAULT nextval('public."Medicine_id_seq"'::regclass);
 <   ALTER TABLE public."Medicine" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            H           2604    16908    MedicineControl id    DEFAULT     |   ALTER TABLE ONLY public."MedicineControl" ALTER COLUMN id SET DEFAULT nextval('public."MedicineControl_id_seq"'::regclass);
 C   ALTER TABLE public."MedicineControl" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            C           2604    16828 
   Patient id    DEFAULT     l   ALTER TABLE ONLY public."Patient" ALTER COLUMN id SET DEFAULT nextval('public."Patient_id_seq"'::regclass);
 ;   ALTER TABLE public."Patient" ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            �          0    16887    FormulatedMedicine 
   TABLE DATA           K   COPY public."FormulatedMedicine" (id, patient_id, medicine_id) FROM stdin;
    public          postgres    false    209   L       �          0    16842    Functionary 
   TABLE DATA           q   COPY public."Functionary" (id, identification, email, password, name, "lastName", "position", phone) FROM stdin;
    public          postgres    false    203   2L       �          0    16866    MedicalAppointmentHistory 
   TABLE DATA           �   COPY public."MedicalAppointmentHistory" (id, patient_id, functionary_id, "requestDate", "applicationDate", "applicationHour", observation, state) FROM stdin;
    public          postgres    false    207   ~M       �          0    16856    Medicine 
   TABLE DATA           W   COPY public."Medicine" (id, "uniqueCode", name, supplier, price, quantity) FROM stdin;
    public          postgres    false    205   �N       �          0    16905    MedicineControl 
   TABLE DATA           r   COPY public."MedicineControl" (id, medicine_id, functionary_id, "registerType", quantity, date, hour) FROM stdin;
    public          postgres    false    211   `O       �          0    16825    Patient 
   TABLE DATA           �   COPY public."Patient" (id, name, "lastName", identification, birthdate, age, genre, phone, district, address, "bloodType", email, password, state) FROM stdin;
    public          postgres    false    201   �O                  0    0    FormulatedMedicine_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."FormulatedMedicine_id_seq"', 2, true);
          public          postgres    false    208                       0    0    Functionary_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public."Functionary_id_seq"', 4, true);
          public          postgres    false    202                       0    0     MedicalAppointmentHistory_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public."MedicalAppointmentHistory_id_seq"', 31, true);
          public          postgres    false    206                       0    0    MedicineControl_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."MedicineControl_id_seq"', 6, true);
          public          postgres    false    210                       0    0    Medicine_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Medicine_id_seq"', 3, true);
          public          postgres    false    204                       0    0    Patient_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Patient_id_seq"', 11, true);
          public          postgres    false    200            `           2606    16892 *   FormulatedMedicine FormulatedMedicine_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."FormulatedMedicine"
    ADD CONSTRAINT "FormulatedMedicine_pkey" PRIMARY KEY (id);
 X   ALTER TABLE ONLY public."FormulatedMedicine" DROP CONSTRAINT "FormulatedMedicine_pkey";
       public            postgres    false    209            R           2606    16851 !   Functionary Functionary_email_key 
   CONSTRAINT     a   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_email_key" UNIQUE (email);
 O   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_email_key";
       public            postgres    false    203            T           2606    16849 *   Functionary Functionary_identification_key 
   CONSTRAINT     s   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_identification_key" UNIQUE (identification);
 X   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_identification_key";
       public            postgres    false    203            V           2606    16853 !   Functionary Functionary_phone_key 
   CONSTRAINT     a   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_phone_key" UNIQUE (phone);
 O   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_phone_key";
       public            postgres    false    203            X           2606    16847    Functionary Functionary_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Functionary"
    ADD CONSTRAINT "Functionary_pkey" PRIMARY KEY (id);
 J   ALTER TABLE ONLY public."Functionary" DROP CONSTRAINT "Functionary_pkey";
       public            postgres    false    203            ^           2606    16874 8   MedicalAppointmentHistory MedicalAppointmentHistory_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_pkey" PRIMARY KEY (id);
 f   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_pkey";
       public            postgres    false    207            b           2606    16913 $   MedicineControl MedicineControl_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_pkey" PRIMARY KEY (id);
 R   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_pkey";
       public            postgres    false    211            Z           2606    16861    Medicine Medicine_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Medicine"
    ADD CONSTRAINT "Medicine_pkey" PRIMARY KEY (id);
 D   ALTER TABLE ONLY public."Medicine" DROP CONSTRAINT "Medicine_pkey";
       public            postgres    false    205            \           2606    16863     Medicine Medicine_uniqueCode_key 
   CONSTRAINT     g   ALTER TABLE ONLY public."Medicine"
    ADD CONSTRAINT "Medicine_uniqueCode_key" UNIQUE ("uniqueCode");
 N   ALTER TABLE ONLY public."Medicine" DROP CONSTRAINT "Medicine_uniqueCode_key";
       public            postgres    false    205            J           2606    16839    Patient Patient_email_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_email_key" UNIQUE (email);
 G   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_email_key";
       public            postgres    false    201            L           2606    16835 "   Patient Patient_identification_key 
   CONSTRAINT     k   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_identification_key" UNIQUE (identification);
 P   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_identification_key";
       public            postgres    false    201            N           2606    16837    Patient Patient_phone_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_phone_key" UNIQUE (phone);
 G   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_phone_key";
       public            postgres    false    201            P           2606    16833    Patient Patient_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Patient"
    ADD CONSTRAINT "Patient_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Patient" DROP CONSTRAINT "Patient_pkey";
       public            postgres    false    201            f           2606    16898 6   FormulatedMedicine FormulatedMedicine_medicine_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."FormulatedMedicine"
    ADD CONSTRAINT "FormulatedMedicine_medicine_id_fkey" FOREIGN KEY (medicine_id) REFERENCES public."Medicine"(id);
 d   ALTER TABLE ONLY public."FormulatedMedicine" DROP CONSTRAINT "FormulatedMedicine_medicine_id_fkey";
       public          postgres    false    2906    209    205            e           2606    16893 5   FormulatedMedicine FormulatedMedicine_patient_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."FormulatedMedicine"
    ADD CONSTRAINT "FormulatedMedicine_patient_id_fkey" FOREIGN KEY (patient_id) REFERENCES public."Patient"(id);
 c   ALTER TABLE ONLY public."FormulatedMedicine" DROP CONSTRAINT "FormulatedMedicine_patient_id_fkey";
       public          postgres    false    2896    209    201            d           2606    16880 G   MedicalAppointmentHistory MedicalAppointmentHistory_functionary_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_functionary_id_fkey" FOREIGN KEY (functionary_id) REFERENCES public."Functionary"(id);
 u   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_functionary_id_fkey";
       public          postgres    false    2904    207    203            c           2606    16875 C   MedicalAppointmentHistory MedicalAppointmentHistory_patient_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."MedicalAppointmentHistory"
    ADD CONSTRAINT "MedicalAppointmentHistory_patient_id_fkey" FOREIGN KEY (patient_id) REFERENCES public."Patient"(id);
 q   ALTER TABLE ONLY public."MedicalAppointmentHistory" DROP CONSTRAINT "MedicalAppointmentHistory_patient_id_fkey";
       public          postgres    false    207    201    2896            h           2606    16919 3   MedicineControl MedicineControl_functionary_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_functionary_id_fkey" FOREIGN KEY (functionary_id) REFERENCES public."Functionary"(id);
 a   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_functionary_id_fkey";
       public          postgres    false    203    2904    211            g           2606    16914 0   MedicineControl MedicineControl_medicine_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."MedicineControl"
    ADD CONSTRAINT "MedicineControl_medicine_id_fkey" FOREIGN KEY (medicine_id) REFERENCES public."Medicine"(id);
 ^   ALTER TABLE ONLY public."MedicineControl" DROP CONSTRAINT "MedicineControl_medicine_id_fkey";
       public          postgres    false    211    2906    205            �      x�3�4�4�2�F\1z\\\ ?      �   <  x�e�1o� ���ǠlU�)j��c��ʎ+�����i'�e�=�?�8�i*���%��Uv1|�/C<�>w�8��F��	�� �*�>t�8Bې���E�r�Z6w�_e�_�Pi.��@�m�D�5�]�����?�`�Tq�S�ɽ 5�lN h;g6�H��c��+p_�'Y��Hh�'�Bc�2�βόZ�&���J�u�5ڙ���
����U~�>>����Mػ��6d�0��:g5|�!�s�c�m�\:��_���;��؊O��Η~F�r��E�aK��?MI��B��ƫ      �   c  x���_n� ���Sp&ۄ�{�z��D]6!�I�d��9v��4k�MBB_�! ``d҄[b �!ʂ�I]���eP�N���a�U�g7N?ߣ�����M��ʔ��j�����5�����=�)� ��3_�Ս�|������-��|&��r����2��]X��^��f9�|cu��ꭐ�=�8�jے���~x��*�,k$��{z[��W�n^�>CzeY�L�Ĭk��yۘ��i?z��`���S�J���i�4Kk����xI�$d��R��Q��2��e�,ۀ59/��ԙ�-�5������\К�.���*͊���!�������$���뎂֌�9���=�E�B+��      �   _   x�-�;� ���a�z =���͆`������O�'��}ݴhr��1�ɀz�����S�O�����ڎ,�b�"���wqLsCD7��      �   l   x�}�1
�@D�:��2It�����f�F���.��0���BBJ�~q�d �J%��$��X�%
��R�	5Mq[�i�F����w�@b��[����oz�kf� ��,�      �   �  x�m��n�0E����`����14�l��m�`!Kee��P2l-�Ԝ�{��N]�}�2�3��V�E�!.4����tL}��Rҕ`���П�v��D���3
��{ix8�����R�R����>�ba���>�x*�� �yD����%W���⸣W�����0Fx�]��P�J��ziݠ�z6h] 2�[>L�������!��\
.�������.4WW]�5��\�J�yU��+��&�c��)�����t):��Ӡ-Kb+C�� ��)��@J[[�*k���}>h7�
Wr��L�O�o䬙�u\x.�[�z���䑅�i_��G��kw���~Lydt�{x���>c����i���Npa�D@��X����+�l�Jջ"�	8D|��-���Ĳ��)N5���f���@i/1�[��%�\�*���R��.a�M�knYV��o?RM�7�}��L�3E��s�s����_w���/d2�     