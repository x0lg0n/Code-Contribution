import argparse
import sys

def calculate_bmi(weight, height, unit_system='metric'):
    """
    Calculate BMI based on weight and height in specified unit system.
    
    Args:
        weight (float): Weight in kg (metric) or pounds (imperial)
        height (float): Height in meters (metric) or inches (imperial)
        unit_system (str): 'metric' or 'imperial'
    
    Returns:
        float: Calculated BMI value
    
    Raises:
        ValueError: If weight or height are not positive numbers
    """
    # Input validation
    if weight <= 0:
        raise ValueError("Weight must be a positive number")
    if height <= 0:
        raise ValueError("Height must be a positive number")
    
    if unit_system == 'imperial':
        # Convert imperial to metric
        weight_kg = weight * 0.453592
        height_m = height * 0.0254
    else:
        weight_kg = weight
        height_m = height
    
    # Prevent division by zero
    if height_m == 0:
        raise ValueError("Height cannot be zero")
    
    bmi = weight_kg / (height_m ** 2)
    return bmi

def get_bmi_category(bmi):
    """
    Get BMI category and health recommendations based on BMI value.
    
    Args:
        bmi (float): Calculated BMI value
    
    Returns:
        tuple: (category, recommendation)
    """
    if bmi < 16:
        category = "Severely Underweight"
        recommendation = "Urgently consult a healthcare professional for evaluation and guidance"
    elif 16 <= bmi < 18.5:
        category = "Underweight"
        recommendation = "Consider consulting a doctor and increasing calorie intake with nutritious foods"
    elif 18.5 <= bmi < 25:
        category = "Normal weight"
        recommendation = "Maintain your current healthy lifestyle with balanced diet and regular exercise"
    elif 25 <= bmi < 30:
        category = "Overweight"
        recommendation = "Consider increasing physical activity and moderating calorie intake"
    elif 30 <= bmi < 35:
        category = "Obese (Class I)"
        recommendation = "Consult a healthcare professional for personalized weight management advice"
    elif 35 <= bmi < 40:
        category = "Obese (Class II)"
        recommendation = "Strongly recommend consulting healthcare professional for comprehensive plan"
    else:
        category = "Severely Obese (Class III)"
        recommendation = "Urgently consult healthcare professional for medical supervision"
    
    return category, recommendation

def get_health_tips():
    """
    Return general health tips.
    
    Returns:
        list: List of health tip strings
    """
    return [
        "Aim for at least 150 minutes of moderate exercise per week",
        "Include fruits and vegetables in your daily diet",
        "Stay hydrated by drinking plenty of water",
        "Get 7-9 hours of quality sleep each night",
        "Limit processed foods and sugary drinks",
        "Practice stress management techniques"
    ]

def validate_positive_float(value):
    """
    Validate that input is a positive float.
    
    Args:
        value (str): Input value to validate
    
    Returns:
        float: Validated positive float value
    
    Raises:
        argparse.ArgumentTypeError: If value is not positive float
    """
    try:
        float_value = float(value)
        if float_value <= 0:
            raise argparse.ArgumentTypeError(f"{value} is not a positive number")
        return float_value
    except ValueError:
        raise argparse.ArgumentTypeError(f"'{value}' is not a valid number")

def interactive_mode():
    """
    Run BMI calculator in interactive mode with user input.
    """
    print("🏥 BMI Calculator & Health Advisor 🏥\n")
    
    # Unit system selection with validation
    while True:
        print("Choose unit system:")
        print("1. Metric (kg, meters)")
        print("2. Imperial (pounds, inches)")
        
        choice = input("Enter choice (1 or 2): ").strip()
        if choice in ['1', '2']:
            break
        print("❌ Invalid choice. Please enter 1 for Metric or 2 for Imperial.\n")
    
    unit_system = 'metric' if choice == '1' else 'imperial'
    
    # Get weight with validation
    while True:
        try:
            weight_input = input(f"Enter weight in {'kg' if unit_system == 'metric' else 'pounds'}: ")
            weight = validate_positive_float(weight_input)
            break
        except argparse.ArgumentTypeError as e:
            print(f"❌ {e}\n")
    
    # Get height with validation
    while True:
        try:
            height_input = input(f"Enter height in {'meters' if unit_system == 'metric' else 'inches'}: ")
            height = validate_positive_float(height_input)
            
            # Additional validation for realistic height ranges
            if unit_system == 'metric' and height < 0.5:
                print("⚠️  Height seems too small. Did you mean to enter in centimeters?")
                if input("Re-enter height? (y/n): ").lower() == 'y':
                    continue
            
            elif unit_system == 'imperial' and (height < 12 or height > 96):
                print("⚠️  Height seems outside typical range. Please double-check your input.")
                if input("Re-enter height? (y/n): ").lower() == 'y':
                    continue
            
            break
        except argparse.ArgumentTypeError as e:
            print(f"❌ {e}\n")
    
    return calculate_and_display(weight, height, unit_system)

def calculate_and_display(weight, height, unit_system):
    """
    Calculate BMI and display results.
    
    Args:
        weight (float): Weight value
        height (float): Height value
        unit_system (str): Unit system ('metric' or 'imperial')
    
    Returns:
        tuple: (bmi, category) for potential programmatic use
    """
    try:
        # Calculate BMI
        bmi = calculate_bmi(weight, height, unit_system)
        category, recommendation = get_bmi_category(bmi)
        
        # Display results
        print(f"\n📊 Results:")
        print(f"BMI: {bmi:.2f}")
        print(f"Category: {category}")
        print(f"Recommendation: {recommendation}")
        
        # Additional health tips
        print(f"\n💡 General Health Tips:")
        for tip in get_health_tips():
            print(f"- {tip}")
        
        return bmi, category
        
    except ValueError as e:
        print(f"❌ Error: {e}")
        return None, None

def main():
    """
    Main function with dual-mode operation: CLI arguments or interactive mode.
    """
    parser = argparse.ArgumentParser(
        description="BMI Calculator & Health Advisor",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  %(prog)s --weight 70 --height 1.75 --unit metric
  %(prog)s --weight 154 --height 69 --unit imperial
  %(prog)s (for interactive mode)
        """
    )
    
    parser.add_argument(
        '--weight', 
        type=validate_positive_float,
        help='Weight in kg (metric) or pounds (imperial)'
    )
    
    parser.add_argument(
        '--height', 
        type=validate_positive_float,
        help='Height in meters (metric) or inches (imperial)'
    )
    
    parser.add_argument(
        '--unit', 
        choices=['metric', 'imperial'],
        help='Unit system: metric or imperial'
    )
    
    args = parser.parse_args()
    
    # Check if running in CLI mode or interactive mode
    if args.weight is not None and args.height is not None and args.unit is not None:
        # CLI mode
        calculate_and_display(args.weight, args.height, args.unit)
    else:
        # Interactive mode
        if any([args.weight, args.height, args.unit]):
            print("⚠️  Incomplete arguments. Switching to interactive mode...\n")
        interactive_mode()

if __name__ == "__main__":
    main()