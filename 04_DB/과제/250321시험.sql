select * from departments;
select * from employees;
select * from jobs;
-- 01. 직원수는 모두 몇명인가?
select count(*) as 직원수
from employees;

--2. 직원 id, firstname, lastname, 부서명을 출력하시오.
select e.employee_id, e.first_name, e.last_name, d.department_name
from employees e, departments d
where e.department_id=d.department_id;

--3. 부서(부서명)별 직원수를 구하시오.
select d.department_name, count(e.employee_id) as 직원수
from departments d, employees e
where d.department_id=e.department_id(+)
group by department_name;

--4. jobtitle별 직원수를 구하시오
select j.job_title, count(e.employee_id) as 직원수
from jobs j, employees e
where j.job_id=e.job_id(+)
group by j.job_title;

--5. 부서(부서명)별 최대급여를 구하시오.
select d.department_name, max(e.salary) as 최대급여
from departments d, employees e
where d.department_id=e.department_id
group by d.department_name;

--6. 전체직원 평균급여보다 적은 급여를 받는 직원의 firstname,lastname과 급여를 구하시오. subquery사용
select first_name, last_name, salary
from employees
where salary<(select avg(salary)
              from employees);

--7. 직원의 fullname (firstname+lastname)과 각 직원의 매니져명(firstname+lastname)을 구하시오.
--   매니져가 없는 직원 포함
select (e1.first_name||' '||e1.last_name)as fullname, decode(e2.employee_id, null, '없음', e2.first_name || ' ' || e2.last_name) AS 매니져명
from employees e1, employees e2
where e1.manager_id=e2.employee_id(+);

--8. 평균급여가 낮은 부서부터 부서명, 평균급여(반올림적용)를 출력하시오
select d.department_name, round(avg(e.salary)) as 평균급여
from departments d, employees e
where d.department_id=e.department_id
group by department_name
order by 평균급여 asc;

--9. 년도별로 입사한 직원수를 구하시오.
-- 출력예시 :   2025   7
select to_char(hire_date, 'yyyy') as 입사년도, count(employee_id) as 직원수
from employees
group by hire_date
order by hire_date desc;

--10. 직원명(firstname+lastname), 부서명, 직책(job)명을 구하시오. ANSI SQL
select (e.first_name||' '||e.last_name) as 직원명, d.department_name as 부서명, j.job_title as 직책
from employees e 
join departments d on e.department_id=d.department_id
join jobs j on e.job_id=j.job_id;