import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'padNumber',
  standalone: true
})

export class PadNumberPipe implements PipeTransform {
  transform(value: number | undefined | null, digits: number = 3): string {
    if (value == undefined || value == null) return '';
    return String(value).padStart(digits, '0');
  }
}