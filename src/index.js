import {
  requireNativeComponent,
  NativeModules,
  StyleSheet,
} from 'react-native';
import React, { Component } from 'react';
import PropTypes from 'prop-types';
var styles = (bottomMargin) =>
  StyleSheet.create({
    antourage: {
      height: 270,
      width: 232,
      position: 'absolute',
      bottom: bottomMargin ?? 0,
      right: 0,
    },
  });
const RNAntourage = requireNativeComponent('AntourageView');

export default class AntourageView extends Component {
  static propTypes = {
    bottomMargin: PropTypes.number,
    portalColor: PropTypes.string,
    nameTextColor: PropTypes.string,
    nameBackgroundColor: PropTypes.string,
    titleTextColor: PropTypes.string,
    titleBackgroundColor: PropTypes.string,
    ctaTextColor: PropTypes.string,
    ctaBackgroundColor: PropTypes.string,
    liveDotColor: PropTypes.string,
  };

  render() {
    const {
      bottomMargin,
      portalColor,
      nameTextColor,
      nameBackgroundColor,
      titleTextColor,
      titleBackgroundColor,
      ctaTextColor,
      ctaBackgroundColor,
      liveDotColor,
    } = this.props;
    return (
      <RNAntourage
        style={styles(bottomMargin).antourage}
        portalColor={portalColor}
        nameTextColor={nameTextColor}
        nameBackgroundColor={nameBackgroundColor}
        titleTextColor={titleTextColor}
        titleBackgroundColor={titleBackgroundColor}
        ctaTextColor={ctaTextColor}
        ctaBackgroundColor={ctaBackgroundColor}
        liveDotColor={liveDotColor}
        ref={(ref) => (this.ref = ref)}
      />
    );
  }
}

export const Antourage = NativeModules.RNAntourage;
