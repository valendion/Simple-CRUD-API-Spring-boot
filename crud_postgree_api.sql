PGDMP     1    !                z            test_api_crud    14.3    14.3 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    32768    test_api_crud    DATABASE     m   CREATE DATABASE test_api_crud WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Indonesia.1252';
    DROP DATABASE test_api_crud;
                postgres    false            ?            1259    32769    employee    TABLE     ?   CREATE TABLE public.employee (
    employee_id bigint NOT NULL,
    employee_name character varying(30),
    employee_address character varying(50)
);
    DROP TABLE public.employee;
       public         heap    postgres    false            ?            1259    40960    employee_id_seq    SEQUENCE        CREATE SEQUENCE public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 987654321
    CACHE 1;
 &   DROP SEQUENCE public.employee_id_seq;
       public          postgres    false            ?          0    32769    employee 
   TABLE DATA           P   COPY public.employee (employee_id, employee_name, employee_address) FROM stdin;
    public          postgres    false    209   ?       ?           0    0    employee_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.employee_id_seq', 2, true);
          public          postgres    false    210            ]           2606    32773    employee employee_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public            postgres    false    209            ?   #   x?3?t???s?J??)M,R?KMO-??????? s??     