@echo off
rem ��ɾ� ��â ��

rem ### ��������	:	v1.0.0
rem ### updated by LJS 

rem chcp 65001>nul
rem ���� https://otrodevym.tistory.com/entry/windows-10-cmd-%EC%9D%B8%EC%BD%94%EB%94%A9-utf-8-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95-949-65001-1

setLocal EnableDelayedExpansion
rem ���� https://kkamagistory.tistory.com/881

rem 0 = ������ 8 = ȸ��
rem 1 = �Ķ��� 9 = ���� �Ķ���
rem 2 = �ʷϻ� A = ���� �ʷϻ�
rem 3 = ���� B = ���� ����
rem 4 = ������ C = ���� ������
rem 5 = ���ֻ� D = ���� ���ֻ�
rem 6 = ����� E = ���� �����
rem 7 = ��� F = ���� ���
rem color 09
rem ù° �ڸ��� ���, ��° �ڸ��� ���ڻ�

rem mode con cols=60 lines=30
rem �ܼ�â ũ�� ����

rem ####################################

cd /d %~dp0
rem ���� ���� ��ġ ��θ� �۾� ��ġ��


title ���� ��� : %cd%
rem title AutoStaging & AutoCommit

:notice
rem 	230117 0938
rem 		- v01.17 init release
rem 	230117 1009
rem 		- v01.17.10 hotfix01

:start
cls
FOR /F "tokens=1-4 delims=- " %%i IN ('date /t') DO SET yyyymmdd=%%i%%j%%k
REM FOR /F "tokens=2-6 delims=/ " %%i IN ('date /t') DO SET yyyymmdd=%%k%%i%%j
rem ECHO %yyyymmdd%

set tm=%time%
set hh=%time:~0,2%
set mm=%time:~3,2%
set ss=%time:~6,2%
set hh1=%time:~0,1%
set hh2=%time:~1,1%
if "%hh1%" == " " set hh=0%hh2%

rem echo original time = %tm%
rem echo transformed time = %hh%%mm%
:choice
echo 	���� ��¥ : %yyyymmdd%
echo 	���� �ð� : %hh%%mm%
echo.

echo 	������ ����� �����ϼ���
rem echo 	1. ���� ������¡
rem echo 	2. ���� Ŀ��
rem echo 	3. ���� Ǫ��
echo 	1. Ŀ�� ��¥ ����(���� ���� q)
echo 	2. ���� Ǫ��(��¥ ���� �� ���)
echo 	q. ����
set /p choice=choice:

rem if %choice% equ 1 goto addAll
rem if %choice% equ 2 goto autoCommit
rem if %choice% equ 3 goto autoPush
if %choice% equ 1 goto changeDate
if %choice% equ 2 goto forcePush
if %choice% equ q exit
cls
goto start

:changeDate
cls
git log
echo ----------------------------------------------------------------------
echo 	��¥ ���� ����Դϴ�.
echo 	���� �ֱ� Ŀ�Ը� ���� �����մϴ�.
echo 	�Ʒ� ���Ŀ� �°� ������ ��¥ �� �ð��� �Է��� �ּ���(�� ���� �ú�)
echo 	ex) 2023 0117 1817
set /p changedDate=�Է� : 
cls
rem set hh=%time:~0,2%
set year=%changedDate:~0,4%
set month=%changedDate:~5,2%
set day=%changedDate:~7,2%
set times1=%changedDate:~10,2%
set times2=%changedDate:~12,2%

if %month% equ 01 set monthStr=Jan
if %month% equ 02 set monthStr=Feb
if %month% equ 03 set monthStr=Mar
if %month% equ 04 set monthStr=Apr
if %month% equ 05 set monthStr=May
if %month% equ 06 set monthStr=Jun
if %month% equ 07 set monthStr=Jul
if %month% equ 08 set monthStr=Aug
if %month% equ 09 set monthStr=Sep
if %month% equ 10 set monthStr=Oct
if %month% equ 11 set monthStr=Nov
if %month% equ 12 set monthStr=Dec

rem if %month:~0,1% equ 0 (
rem 	if %month:~1,1% equ 1 set month=Jan
rem 	if %month:~1,1% equ 2 set month=Feb
rem 	if %month:~1,1% equ 3 set month=Mar
rem 	if %month:~1,1% equ 4 set month=Apr
rem 	if %month:~1,1% equ 5 set month=May
rem 	if %month:~1,1% equ 6 set month=Jun
rem 	if %month:~1,1% equ 7 set month=Jul
rem 	if %month:~1,1% equ 8 set month=Aug
rem 	if %month:~1,1% equ 9 set month=Sep
rem )else (
rem 	rem 10��
rem 	if %month:~1,1% equ 0 set month=Oct
rem 	if %month:~1,1% equ 1 set month=Nov
rem 	if %month:~1,1% equ 2 set month=Dec
rem )

echo 	�Ʒ��� ���� ��ɾ ����մϴ�
echo.
echo 	git commit --amend --no-edit --date "%monthStr% %day% %times1%:%times2%:31 %year% +0000"
echo 	GIT_COMMITTER_DATE="Thu %day% %monthStr% %year% %times1%:%times2%:15 KST" git commit --amend --no-edit
echo.
echo 	����Ϸ��� ����, ����Ϸ��� â�� �ݾ��ּ���
pause
goto start

:forcePush
cls
echo.
echo 	���� Ǫ���Դϴ�. �Ʒ� ��ɾ ����մϴ�
echo 	git push -f origin master
echo 	�����Ϸ��� ����, ��� Ȥ�� ���� �Է��Ϸ��� â�� �ݾ��ּ���
pause
cls
git push -f origin master
pause
goto start




rem :addAll
rem git add .
rem pause
rem cls
rem echo 	���� ���� : 
rem git status
rem pause
rem 
rem goto choice
rem 
rem :autoCommit
rem echo 	"auto push %yyyymmdd%%hh%%mm%"
rem echo 	�� �������� Ŀ���մϴ�
rem echo 	������ ����, ����Ϸ��� â�� ���ּ���
rem pause
rem git commit -m "auto push %yyyymmdd%%hh%%mm%"
rem 
rem goto choice
rem 
rem :autoPush
rem echo 	Ŀ���� ������ Ǫ���մϴ�
rem echo 	������ ����, ����Ϸ��� â�� ���ּ���
rem 
rem pause
rem 
rem git push origin master
rem 
rem goto choice
