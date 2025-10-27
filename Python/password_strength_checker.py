import re
import math
import getpass
from typing import Tuple, List

class PasswordStrengthChecker:
    def __init__(self):
        # Expanded common passwords list
        self.common_passwords = {
            'password', '123456', '12345678', '1234', 'qwerty', '12345', 
            'dragon', 'baseball', 'football', 'letmein', 'monkey', 'abc123',
            'shadow', 'master', 'jennifer', '111111','2000', 'superman',
            '1234567', 'freedom','batman', 'trustno1', 'admin', 'welcome', 
            'password1', '123123'
        }
        
        # Strength thresholds
        self.strength_levels = {
            0: ("Very Weak", "🔴"),
            1: ("Weak", "🟠"), 
            2: ("Fair", "🟡"),
            3: ("Good", "🟢"),
            4: ("Strong", "🟢"),
            5: ("Very Strong", "🟢")
        }

    def calculate_entropy(self, password: str) -> float:
        """Calculate password entropy to measure randomness"""
        if not password:
            return 0
            
        # Character pool size estimation
        char_pool = 0
        if re.search(r'[a-z]', password):
            char_pool += 26
        if re.search(r'[A-Z]', password):
            char_pool += 26
        if re.search(r'[0-9]', password):
            char_pool += 10
        if re.search(r'[^A-Za-z0-9]', password):
            char_pool += 32  # Common special characters
            
        if char_pool == 0:
            return 0
            
        # Entropy formula: log2(pool_size^length)
        entropy = len(password) * math.log2(char_pool)
        return entropy

    def check_common_patterns(self, password: str) -> List[str]:
        """Check for common patterns and sequences"""
        patterns = []
        
        # Repeated characters
        if re.search(r'(.)\1{2,}', password):
            patterns.append("Avoid repeated characters (e.g., 'aaa')")
            
        # Sequential characters
        sequences = ['abc', '123', 'qwe', 'asd', 'zxc']
        password_lower = password.lower()
        for seq in sequences:
            if seq in password_lower or seq[::-1] in password_lower:
                patterns.append(f"Avoid sequential patterns like '{seq}'")
                break
                
        # Repeated substrings
        if len(password) >= 6:
            for i in range(3, len(password)//2 + 1):
                for j in range(len(password) - i*2 + 1):
                    substring = password[j:j+i]
                    if password.count(substring) >= 2:
                        patterns.append("Avoid repeated character sequences")
                        return patterns
                        
        return patterns

    def check_password_strength(self, password: str) -> Tuple[str, str, List[str], int]:
        """Comprehensive password strength analysis"""
        score = 0
        feedback = []
        
        # Length scoring (more granular)
        if len(password) >= 16:
            score += 2
            feedback.append("✅ Excellent password length")
        elif len(password) >= 12:
            score += 1
            feedback.append("✅ Good password length")
        elif len(password) >= 8:
            score += 1
            feedback.append("⚠️  Consider using 12+ characters for better security")
        else:
            feedback.append("❌ Password should be at least 8 characters long")

        # Character diversity scoring
        checks = {
            'uppercase': (r'[A-Z]', "Include uppercase letters"),
            'lowercase': (r'[a-z]', "Include lowercase letters"), 
            'numbers': (r'[0-9]', "Include numbers"),
            'special': (r'[^A-Za-z0-9]', "Include special characters")
        }
        
        for check_type, (pattern, message) in checks.items():
            if re.search(pattern, password):
                score += 1
                feedback.append(f"✅ Contains {check_type} characters")
            else:
                feedback.append(f"❌ {message}")

        # Common password check (improved)
        normalized_password = re.sub(r'[^a-z0-9]', '', password.lower())
        if (password.lower() in self.common_passwords or 
            normalized_password in self.common_passwords):
            score = max(0, score - 2)  # Heavy penalty for common passwords
            feedback.append("❌ This is a commonly used password - choose something more unique")

        # Entropy check
        entropy = self.calculate_entropy(password)
        if entropy >= 60:
            score += 1
            feedback.append("✅ High entropy - excellent randomness")
        elif entropy >= 40:
            feedback.append("⚠️  Moderate entropy - consider more random characters")
        else:
            feedback.append("❌ Low entropy - password is too predictable")

        # Pattern checks
        pattern_feedback = self.check_common_patterns(password)
        if pattern_feedback:
            score = max(0, score - 1)
            feedback.extend(pattern_feedback)

        # Cap score at maximum
        score = min(score, 5)
        
        # Get strength rating
        strength, emoji = self.strength_levels.get(score, ("Very Weak", "🔴"))
        
        return strength, emoji, feedback, score

    def get_strength_breakdown(self, password: str):
        """Provide detailed strength analysis"""
        strength, emoji, feedback, score = self.check_password_strength(password)
        
        print(f"\n{'='*50}")
        print(f"Password Strength: {strength} {emoji} ({score}/5)")
        print(f"{'='*50}")
        
        # Prioritize feedback - show most critical first
        critical = [f for f in feedback if f.startswith('❌')]
        warnings = [f for f in feedback if f.startswith('⚠️')]
        positive = [f for f in feedback if f.startswith('✅')]
        
        if critical:
            print("\nCritical Issues:")
            for item in critical[:3]:  # Show top 3 critical issues
                print(f"  {item}")
                
        if warnings:
            print("\nSuggestions:")
            for item in warnings[:3]:  # Show top 3 suggestions
                print(f"  {item}")
                
        if positive and not critical:  # Only show positives if no critical issues
            print("\nStrengths:")
            for item in positive[:3]:
                print(f"  {item}")

def interactive_mode():
    """Interactive password checking with retries"""
    checker = PasswordStrengthChecker()
    
    print("🔐 Advanced Password Strength Checker")
    print("=" * 40)
    
    while True:
        password = getpass.getpass("\nEnter password to check (or 'quit' to exit): ")
        
        if password.lower() == 'quit':
            break
            
        if not password:
            print("❌ Please enter a password")
            continue
            
        checker.get_strength_breakdown(password)
        
        # Offer to check another password
        continue_check = input("\nCheck another password? (y/n): ").lower()
        if continue_check != 'y':
            break

def quick_check_mode(password: str):
    """Quick check mode for programmatic use"""
    checker = PasswordStrengthChecker()
    strength, emoji, feedback, score = checker.check_password_strength(password)
    
    return {
        'strength': strength,
        'emoji': emoji,
        'score': score,
        'feedback': feedback
    }

# Test function
def test_passwords():
    """Test various password examples"""
    test_cases = [
        "password",           # Very weak
        "123456",             # Very weak  
        "Password1",          # Weak
        "Password123",        # Fair
        "SecurePass123!",     # Good
        "MyV3ryS3cur3P@ssw0rd2024!"  # Strong
    ]
    
    checker = PasswordStrengthChecker()
    
    print("Testing Password Examples:")
    print("=" * 50)
    
    for pwd in test_cases:
        result = quick_check_mode(pwd)
        print(f"\nPassword: {pwd}")
        print(f"Strength: {result['strength']} {result['emoji']} ({result['score']}/5)")

if __name__ == "__main__":
    # Run in interactive mode by default
    interactive_mode()
    
    # Uncomment to run tests
    # test_passwords()