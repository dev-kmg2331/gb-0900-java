@echo off
rem ��ɾ� ��â ��

rem ### ��������	:	v0116_alpha
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
rem 	autoAddCommitPush
rem 		- �ش������� ª�� ���� ����.
rem 		- ��� ������� ������¡, �ڵ�Ŀ��, �ڵ� Ǫ���Ѵ�.

:makeDate
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
cls
rem
:start
echo 	[git add .]
echo 	[git commit -m "auto push %yyyymmdd% %hh%%mm%"]
echo 	[git push origin master]
echo 	�� ��ɾ �Ѳ����� �����ϴ� ���α׷��Դϴ�.
echo 	�����Ϸ��� ����, ����Ϸ��� �� â�� �ݾ��ּ���
pause

git add .
git commit -m "auto push %yyyymmdd% %hh%%mm%"
git push origin master
echo 	----------------------------------------------
echo 	���� ���ο� �����ϰ�, �۾��� �Ϸ�Ǿ����ϴ�.
echo 	���� �α׸� �������ּ���.
echo 	----------------------------------------------
pause