@echo off
rem ��ɾ� ��â ��

rem ### ��������	:	v0119_alpha
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
rem 	230116 v0116_alpha
rem 		- add, restore, commit, push ����
rem		230118 v0118_beta
rem			- hotfixes
rem		230119 v0119_alpha
rem			- add changeDate

:start
set choice=1
@echo off
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
echo.
echo 	������ ����� ������ �ּ���
rem echo 	0. 
echo 	[1]. cd (�۾� ��ġ �̵�)
echo 	[2]. git add(������¡)
echo 	[3]. git restore(������¡ ������)
echo 	[4]. git commit(Ŀ��)
echo 	[5]. git push(Ǫ��)
echo 	[6]. Ŀ�� ��¥ ����
echo 	[q]. ���α׷� ����
echo.
set /p choice=����(��: 1 ����) :

if %choice% equ 1 goto OnDirectory
if %choice% equ 2 goto add
if %choice% equ 3 goto restore
if %choice% equ 4 goto commit
if %choice% equ 5 goto push
if %choice% equ 6 goto changeDate
if /i %choice% equ q exit
goto start

rem ##########���͸� Ž��##########
:OnDirectory
cls
title ���� ���͸� ��� : %cd%
set /a dirnum=0
set /a dirlistnum=1
rem #####���͸� ����Ʈ �迭[1~N]#####
set dirlist=NULL
for /f %%i in ('dir /a:d /b') do set /a dirnum=dirnum+1
if %dirnum% lss 1 goto NoDir
for /f "tokens=*" %%i in ('dir /a:d /b') do (set dirlist[%dirlistnum%]=%%i & goto LoadDirList)
:LoadDirList
set /a dirlistnum=dirlistnum+1
rem #####����Ʈ�� �ε����� 1���� ����, ���� ���彺ŵ�� ����Ʈ�� �ε��� - 1#####
set /a skips=dirlistnum-1
if %skips% equ %dirnum% goto EOF
for /f "tokens=* skip=%skips%" %%i in ('dir /a:d /b') do (set dirlist[%dirlistnum%]=%%i & goto LoadDirList)
goto quit
:EOF
cls
git status
echo ----------------------------------------------------------------------
echo ���� ��� : %cd%
echo ----------------------------------------------------------------------
for /l %%i in (1,1,%dirnum%) do echo %%i. !dirlist[%%i]!
echo %dirlistnum%. [..]���� ���͸��� ����
echo ----------------------------------------------------------------------
echo ���� ����� ���͸� �� : %dirnum%
echo ���� ��θ� �۾��������� �����ϱ� : [S] �Է�(��ҹ��� ����)
set /a dirnum=dirnum+1
set dirlist[%dirlistnum%]=..
set /p Todir=Choice : 
if /i %Todir% equ S goto quitExplore
rem if %Todir% equ s goto quitExplore
set /a temp=Todir-1
if %Todir% gtr %dirnum% (echo 1~%dirnum%������ ���� �����մϴ�. & pause>nul & cls & set /a dirnum=dirnum-1 & goto EOF)
if %temp% lss 0 (echo 1~%dirnum%������ ���� �����մϴ�. & pause>nul & cls & set /a dirnum=dirnum-1 & goto EOF)
goto MvDir
:NoDir
cls
git status
echo ----------------------------------------------------------------------
echo ���� ��� : %cd%
echo ----------------------------------------------------------------------
echo %dirlistnum%. [..]���� ���͸��� ����
echo ----------------------------------------------------------------------
echo ���� ����� ���͸� �� : %dirnum%
echo ���� ��θ� �۾��������� �����ϱ� : [S] �Է�(��ҹ��� ����)
set /a dirnum=dirnum+1
set dirlist[%dirlistnum%]=..
set /p Todir=Choice : 
if /i %Todir% equ S goto quitExplore
rem if %Todir% equ s goto quitExplore
set /a temp=Todir-1
if %temp% neq 0 (echo ���� ���͸��� ���͸��� �����ϴ�. & pause>nul & cls & set /a dirnum=dirnum-1 & goto EOF)
goto MvDir

:MvDir
cd !dirlist[%Todir%]!
cls
goto OnDirectory
:quitExplore
set /a skips=1
set /a number=1

cls & title �۾��� ���͸� ��� : %cd%
goto start

:add

:addFor
set select=:
cls
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
echo 	(���� ��� : %cd%)
echo 	������¡�� ������ ������ ����� �����Ͽ� �Է��� �ּ���
echo 	ex) class .gitignore test.txt
echo 	��� ���� ������¡ [.] �Է�
echo 	�������� ���ư����� [:q] �Է�
set /p select=�Է�: 
rem echo %select%
if %select% equ :q cls&goto start
rem if "%select%==:" goto doStaging
set stagingList=%select%
cls
:doStaging
git add %stagingList%
echo ----------------------------------------------------------------------
echo ������¡�� : %stagingList%
echo ----------------------------------------------------------------------
echo Enter �Է½� ��������
pause
cls
goto start

:restore
set restoreTemp=:q
cls
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
rem echo ������¡ ��� ���� : %restoreTemp%
echo 	Ŀ������ ����, add�� �����̳� ������ ��� �Է��ϼ���.
echo 	�������� ���ư����� [:q] �Է�
set /p restoreTemp=�Է�: 
echo ----------------------------------------------------------------------

if %restoreTemp%==:q goto start

git restore --staged %restoreTemp%
echo ----------------------------------------------------------------------

goto start

:commit
set choiceCommit=q
cls
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
echo 	-Ŀ�� �޽��� �Է�-
echo 	[1]. ���� �Է�
echo 	[2]. ���� Ŀ��
echo 		����:	"yyyyMMdd hhmm AutoCommit"
echo 		ex)	"20230116 1840 AutoCommit"
echo 	[q]. ���θ޴���
set /p choiceCommit=�Է� : 
if %choiceCommit% equ 1 goto customCommit
if %choiceCommit% equ 2 goto autoCommit
if %choiceCommit% equ q goto start
echo 	�߸��Է��ϼ̽��ϴ�.
pause
goto commit

:customCommit
set commitMsg=
cls
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
echo 	Ŀ���� ������ �Է��ϼ���
echo 	[q]. ���θ޴���
set /p commitMsg=�Է� : 
rem if commitMsg== echo 	�߸� �Է��ϼ̽��ϴ�&pause&goto customCommit
if /i %commitMsg% equ q goto start
pause
echo 	[git commit -m "%commitMsg%"]
echo 	���� ���� ��ɾ �����մϴ�.
set /p yon=[y/n]
if /i %yon% equ y goto doCommit
if /i %yon% equ n goto commit
cls
goto start

:doCommit
cls
git commit -m "%commitMsg%"
pause
cls
echo ----------------------------------------------------------------------
echo 	commit Message : %commitMsg%
echo ----------------------------------------------------------------------
goto start

:autoCommit
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
cls
echo ----------------------------------------------------------------------
echo 	[commit : auto push %yyyymmdd% %hh%%mm%]
git commit -m "auto push %yyyymmdd% %hh%%mm%"
echo ----------------------------------------------------------------------
goto start

:push
cls
echo ----------------------------------------------------------------------
git status
echo ----------------------------------------------------------------------
echo 	Ǫ���Ͻðڽ��ϱ�?
echo 	[1]. git push origin master
echo 	[2]. ���� �Է�
echo 	[q]. ���θ޴���
set /p choicePush=choice: 
if %choicePush% equ 1 git push origin master&goto start
if %choicePush% equ 2 goto customPush
if %choicePush% equ q goto start
echo 	�߸� �Է��ϼ̽��ϴ�
pause
goto push

:customPush
echo 	### custom push ###
echo 	git push�� ������ ��ɾ �Է��� �ּ���
echo 	ex) git push origin master ->
echo 	origin master �� �Է�
rem echo 	push�� ����Ϸ��� ���� ����� X�� ���� �������ּ���
echo 	[q]. ���θ޴��� �̵�
set /p pushPath=�Է�: 
if %pushPath% equ q cls&goto start
echo 	[git push %pushPath%]
echo 	�� ��ɾ �����մϴ�.
echo 	����Ϸ��� �ƹ�Ű �Է�, ����Ϸ��� ���� ����� x�� �����ּ���.
pause
git push %pushPath%
pause
cls
goto start


:changeDate
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

