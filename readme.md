# cordova-plugin-open-scheme-url

Open a scheme url/deep link.

## Methods

### `open`
Opens a scheme url/deep url.

#### Example:
```javascript
const {OpenSchemeUrl} = window.cordova.plugins;

OpenSchemeUrl.open('itms-apps://itunes.apple.com/no/app/youtube/id544007664', () => {
    console.log('URL opened successfully.');
}, () => {
    console.log('URL schema not handled.');
    window.location.href = 'https://itunes.apple.com/no/app/youtube/id544007664';
});
```

```javascript
const {OpenSchemeUrl} = window.cordova.plugins;

OpenSchemeUrl.open('market://details?id=com.google.android.youtube', () => {
    console.log('URL opened successfully.');
}, () => {
    console.log('URL schema not handled.');
    window.location.href = 'https://play.google.com/store/apps/details?id=com.google.android.youtube';
});
```
