# PowerShell script to permanently set Java bin folder in PATH and JAVA_HOME
# Run this script as Administrator

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Java Environment Setup Script (Permanent)" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check if running as Administrator
$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)
if (-not $isAdmin) {
    Write-Host "WARNING: This script requires Administrator privileges to set system environment variables." -ForegroundColor Yellow
    Write-Host "Please run PowerShell as Administrator and try again." -ForegroundColor Yellow
    Write-Host ""
    Write-Host "Right-click PowerShell and select 'Run as Administrator'" -ForegroundColor Yellow
    pause
    exit 1
}

# Check common Java installation locations
$javaPath = $null
$javaFound = $false

# Check Program Files\Java
if (Test-Path "C:\Program Files\Java") {
    $javaDirs = Get-ChildItem "C:\Program Files\Java" -Directory
    foreach ($dir in $javaDirs) {
        if (Test-Path (Join-Path $dir.FullName "bin\java.exe")) {
            $javaPath = $dir.FullName
            $javaFound = $true
            break
        }
    }
}

# Check Program Files (x86)\Java
if (-not $javaFound -and (Test-Path "C:\Program Files (x86)\Java")) {
    $javaDirs = Get-ChildItem "C:\Program Files (x86)\Java" -Directory
    foreach ($dir in $javaDirs) {
        if (Test-Path (Join-Path $dir.FullName "bin\java.exe")) {
            $javaPath = $dir.FullName
            $javaFound = $true
            break
        }
    }
}

# Check user's local Java installation
if (-not $javaFound -and (Test-Path "$env:LOCALAPPDATA\Programs\Java")) {
    $javaDirs = Get-ChildItem "$env:LOCALAPPDATA\Programs\Java" -Directory
    foreach ($dir in $javaDirs) {
        if (Test-Path (Join-Path $dir.FullName "bin\java.exe")) {
            $javaPath = $dir.FullName
            $javaFound = $true
            break
        }
    }
}

# If not found, ask user
if (-not $javaFound) {
    Write-Host "Java installation not found automatically." -ForegroundColor Yellow
    Write-Host ""
    Write-Host "Please provide the path to your Java JDK installation folder." -ForegroundColor Yellow
    Write-Host "Example: C:\Program Files\Java\jdk-17" -ForegroundColor Yellow
    Write-Host ""
    $javaPath = Read-Host "Enter Java JDK path"
    
    if (-not (Test-Path (Join-Path $javaPath "bin\java.exe"))) {
        Write-Host "ERROR: Java not found at the specified path!" -ForegroundColor Red
        pause
        exit 1
    }
}

Write-Host ""
Write-Host "Found Java at: $javaPath" -ForegroundColor Green
Write-Host ""

# Verify Java installation
Write-Host "Verifying Java installation..." -ForegroundColor Cyan
& "$javaPath\bin\java.exe" -version
if ($LASTEXITCODE -ne 0) {
    Write-Host "ERROR: Java verification failed!" -ForegroundColor Red
    pause
    exit 1
}

Write-Host ""

# Set JAVA_HOME system environment variable
Write-Host "Setting JAVA_HOME system environment variable..." -ForegroundColor Cyan
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", $javaPath, [System.EnvironmentVariableTarget]::Machine)
Write-Host "JAVA_HOME set to: $javaPath" -ForegroundColor Green

# Add Java bin to PATH
Write-Host ""
Write-Host "Adding Java bin to system PATH..." -ForegroundColor Cyan
$javaBinPath = Join-Path $javaPath "bin"
$currentPath = [System.Environment]::GetEnvironmentVariable("Path", [System.EnvironmentVariableTarget]::Machine)

if ($currentPath -notlike "*$javaBinPath*") {
    $newPath = $currentPath + ";" + $javaBinPath
    [System.Environment]::SetEnvironmentVariable("Path", $newPath, [System.EnvironmentVariableTarget]::Machine)
    Write-Host "Java bin folder added to PATH: $javaBinPath" -ForegroundColor Green
} else {
    Write-Host "Java bin folder already in PATH." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Setup complete!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "JAVA_HOME and PATH have been set permanently." -ForegroundColor Green
Write-Host "You may need to restart your terminal/IDE for changes to take effect." -ForegroundColor Yellow
Write-Host ""
pause

