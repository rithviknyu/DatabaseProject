CREATE PROCEDURE `CorporateCustomerRegistration`(
	cust_id bigint,
    emp_id bigint,
    regis_num bigint,
    street_name varchar(50),
    city_name varchar(50),
    state_name varchar(20),
    zip_code varchar(6),
    phone_no varchar(14),
    email_id varchar(100),
    cust_type varchar(1)
)
BEGIN
	DECLARE new_custid BIGINT;
    SELECT COALESCE(MAX(prs_customer2.custid), 0) + 1 INTO new_custid FROM prs_customer2;

    INSERT INTO prs_customer2 VALUES (
        new_custid,
        street_name,
        city_name,
        state_name,
        zip_code,
        phone_no,
        email_id,
        cust_type
    );

    INSERT INTO prs_corporate2 (
    custid,
    empid,
    regisnum
    )
    VALUES (
        new_custid,
        emp_id,
        regis_num
    );

	select max(custid) from prs_customer2;
END

CREATE PROCEDURE `IndividualCustomerRegistration`(
	cust_id bigint,
    f_name varchar(50),
    m_name varchar(50),
    l_name varchar(50),
    dlicense_no varchar(16),
    ins_name varchar(255),
    insp_num varchar(30),
    street_name varchar(50),
    city_name varchar(50),
    state_name varchar(20),
    zip_code varchar(6),
    phone_no varchar(14),
    email_id varchar(100),
    cust_type varchar(1)
)
BEGIN
	DECLARE new_custid BIGINT;
    SELECT COALESCE(MAX(prs_customer2.custid), 0) + 1 INTO new_custid FROM prs_customer2;

    INSERT INTO prs_customer2 VALUES (
        new_custid,
        street_name,
        city_name,
        state_name,
        zip_code,
        phone_no,
        email_id,
        cust_type
    );

    INSERT INTO prs_individual2 (
    custid,
    fname,
	mname,
	lname,
    insname,
    inspnum
    )
    VALUES (
        new_custid,
        f_name,
        m_name,
        l_name,
        ins_name,
        insp_num
    );

	select max(custid) from prs_customer2;

END

CREATE PROCEDURE `DeleteDiscount`(dis_id int)
BEGIN
	delete from prs_disindividual where prs_disindividual.disid = dis_id;
    delete from prs_discorporate where prs_discorporate.disid = dis_id;
    delete from prs_discount where prs_discount.disid = dis_id;

    select disid from prs_discount where disid=dis_id;
END