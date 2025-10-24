"""
Linear Regression Example

This script demonstrates a simple linear regression using scikit-learn.
It fits a model to sample data and predicts the output for a given input.
"""


import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
import numpy as np



# Sample data
np.random.seed(42)
X = np.random.rand(100, 1) * 10
y = (10 * X + np.random.randn(100, 1) * 15).flatten()

df = pd.DataFrame({'x': X.flatten(), 'y': y})

# Define features (X) and target variable (Y)
X = df[['x']]  # Features must be in 2D array format
Y = df['y']    # Target variable
X_train,X_test,y_train,y_test = train_test_split(X,Y,test_size = 0.25,random_state = 42) #split the data to avoid overfitting and for effective predictions

#scaling the data
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)
model = LinearRegression()

# Fit the model to the data
model.fit(X_train_scaled, y_train)


# Make predictions on test data
prediction = model.predict(X_test_scaled)

#visualize the linear regression model using scatter plots
plt.scatter(X_train, y_train, color='blue', label='Training Data')
plt.scatter(X_test, y_test, color='red', label='Testing Data')
plt.plot(X_test, prediction, color='green', linewidth=2, label='Regression Line')
plt.xlabel('X')
plt.ylabel('Y')
plt.legend()
plt.show()
prediction_df = pd.DataFrame({'Actual': y_test, 'Predicted': prediction})
prediction_df = prediction_df.reset_index(drop=True)

print("\n The predicted values are:")
print(prediction_df)

# Predict for any x = num
x = np.array([[9]])
x_scaled = scaler.transform(x)
pred_value = model.predict(x_scaled)
print("The predicted value for", x," is:",pred_value)
