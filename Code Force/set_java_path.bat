@echo off
REM Script to set Java bin folder in PATH and JAVA_HOME

echo ========================================
echo Java Environment Setup Script
echo ========================================
echo.

REM Check common Java installation locations
set "JAVA_FOUND=0"

REM Check Program Files\Java
if exist "C:\Program Files\Java" (
    for /d %%i in ("C:\Program Files\Java\*") do (
        if exist "%%i\bin\java.exe" (
            set "JAVA_HOME_PATH=%%i"
            set "JAVA_FOUND=1"
            goto :found
        )
    )
)

REM Check Program Files (x86)\Java
if exist "C:\Program Files (x86)\Java" (
    for /d %%i in ("C:\Program Files (x86)\Java\*") do (
        if exist "%%i\bin\java.exe" (
            set "JAVA_HOME_PATH=%%i"
            set "JAVA_FOUND=1"
            goto :found
        )
    )
)

REM Check if user has a custom Java installation
if exist "%LOCALAPPDATA%\Programs\Java" (
    for /d %%i in ("%LOCALAPPDATA%\Programs\Java\*") do (
        if exist "%%i\bin\java.exe" (
            set "JAVA_HOME_PATH=%%i"
            set "JAVA_FOUND=1"
            goto :found
        )
    )
)

:found
if %JAVA_FOUND%==0 (
    echo ERROR: Java installation not found automatically.
    echo.
    echo Please provide the path to your Java JDK installation folder.
    echo Example: C:\Program Files\Java\jdk-17
    echo.
    set /p JAVA_HOME_PATH="Enter Java JDK path: "
    
    if not exist "%JAVA_HOME_PATH%\bin\java.exe" (
        echo ERROR: Java not found at the specified path!
        pause
        exit /b 1
    )
)

echo.
echo Found Java at: %JAVA_HOME_PATH%
echo.

REM Set JAVA_HOME for current session
set JAVA_HOME=%JAVA_HOME_PATH%
set PATH=%JAVA_HOME%\bin;%PATH%

echo JAVA_HOME is now set to: %JAVA_HOME%
echo Java bin folder added to PATH for this session.
echo.

REM Verify Java installation
echo Verifying Java installation...
"%JAVA_HOME%\bin\java.exe" -version
if errorlevel 1 (
    echo ERROR: Java verification failed!
    pause
    exit /b 1
)

echo.
echo ========================================
echo Setup complete for current session!
echo ========================================
echo.
echo NOTE: These settings are only for the current command prompt session.
echo To make them permanent, you need to:
echo.
echo 1. Set JAVA_HOME system environment variable:
echo    - Right-click "This PC" ^> Properties ^> Advanced system settings
echo    - Click "Environment Variables"
echo    - Under "System variables", click "New"
echo    - Variable name: JAVA_HOME
echo    - Variable value: %JAVA_HOME%
echo.
echo 2. Add Java to PATH:
echo    - Edit the PATH system variable
echo    - Add: %%JAVA_HOME%%\bin
echo    - Or add directly: %JAVA_HOME%\bin
echo.
pause

