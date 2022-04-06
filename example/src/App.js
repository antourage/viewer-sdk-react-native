import React, { Component } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import AntourageView, { Antourage } from 'antourage-react-native';

const styles = StyleSheet.create({
  screen: { flex: 1, justifyContent: 'center', alignItems: 'center' },
});

function Tab1Screen() {
  return (
    <View style={styles.screen}>
      <Text>Tab 1</Text>
      <AntourageView />
    </View>
  );
}

function Tab2Screen() {
  return (
    <View style={styles.screen}>
      <Text>Tab 2</Text>
    </View>
  );
}

function Tab3Screen() {
  return (
    <View style={styles.screen}>
      <Text>Tab 3</Text>
      <AntourageView portalColor={'#0000ff'} bottomMargin={40} />
    </View>
  );
}

const Tab = createBottomTabNavigator();

export default class App extends Component {
  componentDidMount() {
    Antourage.configure(1);
  }

  render() {
    return (
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name="Tab 1" component={Tab1Screen} />
          <Tab.Screen name="Tab 2" component={Tab2Screen} />
          <Tab.Screen name="Tab 3" component={Tab3Screen} />
        </Tab.Navigator>
      </NavigationContainer>
    );
  }
}
