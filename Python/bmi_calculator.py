def calculate_bmi(weight, height, unit_system='metric'):
    """
    Calculate BMI and provide health recommendations
    """
    if unit_system == 'imperial':
        # Convert imperial to metric
        weight_kg = weight * 0.453592
        height_m = height * 0.0254
    else:
        weight_kg = weight
        height_m = height
    
    bmi = weight_kg / (height_m ** 2)
    return bmi

def get_bmi_category(bmi):
    """Get BMI category and health recommendations"""
    if bmi < 18.5:
        category = "Underweight"
        recommendation = "Consider consulting a doctor and increasing calorie intake with nutritious foods"
    elif 18.5 <= bmi < 25:
        category = "Normal weight"
        recommendation = "Maintain your current healthy lifestyle with balanced diet and regular exercise"
    elif 25 <= bmi < 30:
        category = "Overweight"
        recommendation = "Consider increasing physical activity and moderating calorie intake"
    else:
        category = "Obese"
        recommendation = "Consult a healthcare professional for personalized weight management advice"
    
    return category, recommendation

def main():
    print("🏥 BMI Calculator & Health Advisor 🏥\n")
    
    # Unit system selection
    print("Choose unit system:")
    print("1. Metric (kg, meters)")
    print("2. Imperial (pounds, inches)")
    
    choice = input("Enter choice (1 or 2): ")
    
    if choice == '1':
        unit_system = 'metric'
        weight = float(input("Enter weight in kg: "))
        height = float(input("Enter height in meters: "))
    else:
        unit_system = 'imperial'
        weight = float(input("Enter weight in pounds: "))
        height = float(input("Enter height in inches: "))
    
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
    print("- Aim for at least 150 minutes of moderate exercise per week")
    print("- Include fruits and vegetables in your daily diet")
    print("- Stay hydrated by drinking plenty of water")
    print("- Get 7-9 hours of quality sleep each night")

if __name__ == "__main__":
    main()